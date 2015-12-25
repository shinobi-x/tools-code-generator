package cn.uc.codegenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import cn.uc.codegenerator.module.Column;
import cn.uc.codegenerator.module.Database;
import cn.uc.codegenerator.module.Table;
import cn.uc.codegenerator.util.DateUtil;
import cn.uc.codegenerator.util.FileUtil;
import cn.uc.codegenerator.util.JdbcUtil;
import cn.uc.codegenerator.util.PropertiesUtil;
import cn.uc.codegenerator.util.TemplateUtil;
import cn.uc.codegenerator.util.TypeUtil;

public class CodeGenerator {

    public static void main(String[] args) throws Exception {
        CodeGenerator cg = new CodeGenerator();
        cg.generate();
    }

    public void generate() throws Exception {
        Database dbInfo = getDatabaseInfo();
        String projectType = dbInfo.getProjectType();

        for (Table table : dbInfo.getTableList()) {

            Map<String, String> templageMap = TemplateUtil.getFileToPath(dbInfo, table.getObjectName());

            for (Map.Entry<String, String> entry : templageMap.entrySet()) {
                String context = TemplateUtil.getText(projectType, (String) entry.getKey(), table);
                String filePath = FileUtil.getClassPath() + "target/" + (String) entry.getValue();
                FileUtil.string2File(context, filePath);
            }
        }
    }

    public Database getDatabaseInfo() throws Exception {
        Database dbInfo = new Database();
        Connection connection = null;
        try {
            String driver = "com.mysql.jdbc.Driver";
            String host = PropertiesUtil.getProperties("jdbc.host");
            String database = PropertiesUtil.getProperties("jdbc.database");
            String userName = PropertiesUtil.getProperties("jdbc.userName");
            String password = PropertiesUtil.getProperties("jdbc.password");
            String domain = PropertiesUtil.getProperties("domain");
            String model = PropertiesUtil.getProperties("model");
            String author = PropertiesUtil.getProperties("author");
            String projectType = PropertiesUtil.getProperties("projectType");
            String current = DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss");

            dbInfo.setDomain(domain);
            dbInfo.setModel(model);
            dbInfo.setAuthor(author);
            dbInfo.setProjectType(projectType);
            dbInfo.setCreateTime(current);

            String url = "jdbc:mysql://" + host + "/" + database + "?characterEncoding=utf-8";
            connection = JdbcUtil.getConnection(driver, url, userName, password);

            List<Table> tableList = getTableList(connection, database);
            for (Table table : tableList) {
                table.setDomain(domain);
                table.setModel(model);
                table.setAuthor(author);
                table.setCreateTime(current);
                List<Column> columnList = getColumnList(connection, database, table.getTableName());
                table.setColumnList(columnList);
                
                for (Column column : columnList) {
                    if("is_enable".equals(column.getColumnName())){
                        table.setContainsIsEnable(true);
                    }
                    
                    if("update_time".equals(column.getColumnName())){
                        table.setContainsUpdateTime(true);
                    }
                }
            }

            dbInfo.setTableList(tableList);

        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return dbInfo;
    }

    public List<Table> getTableList(Connection connection, String databaseName) throws Exception {
        Statement statement = connection.createStatement();
        ResultSet rs = statement
                .executeQuery("select table_name,table_comment from information_schema.tables where table_schema = '"
                        + databaseName + "'");

        List<Table> tableList = new ArrayList<Table>();
        while (rs.next()) {
            Table table = new Table();
            String tableName = rs.getString("table_name");
            table.setTableName(tableName);
            table.setComment(rs.getString("table_comment"));
            
            table.setObjectName(getObjectName(tableName));
            table.setLobjectName(getLobjectName(tableName));

            tableList.add(table);
        }

        return tableList;
    }

    private String getObjectName(String tableName) {
        tableName = tableName.replaceFirst("tb_", "");
        String[] tableNameSplit = tableName.split("_");

        StringBuffer objectName = new StringBuffer();

        for (int i = 0; i < tableNameSplit.length; i++) {
            objectName.append(StringUtils.capitalize(StringUtils.lowerCase(tableNameSplit[i])));
        }

        return objectName.toString();
    }
    
    private String getLobjectName(String tableName) {
        tableName = tableName.replaceFirst("tb_", "");
        String[] tableNameSplit = tableName.split("_");

        StringBuffer objectName = new StringBuffer();

        for (int i = 0; i < tableNameSplit.length; i++) {
            if(i == 0){
                objectName.append(StringUtils.lowerCase(tableNameSplit[i]));
            }else{
                objectName.append(StringUtils.capitalize(StringUtils.lowerCase(tableNameSplit[i])));
            }
        }

        return objectName.toString();
    }
    
    public List<Column> getColumnList(Connection connection, String databaseName, String tableName) throws Exception {

        Statement statement = connection.createStatement();
        ResultSet rs = statement
                .executeQuery("SELECT column_name,column_type,data_type,column_comment FROM information_schema.COLUMNS WHERE table_schema = '"
                        + databaseName + "' and table_name = '" + tableName + "'");

        List<Column> columnList = new ArrayList<Column>();
        while (rs.next()) {
            Column column = new Column();
            String columnName = rs.getString("column_name");
            column.setColumnName(columnName);
            column.setColumnType(rs.getString("column_type"));
            String dataType = rs.getString("data_type");
            column.setDataType(dataType);
            column.setComment(rs.getString("column_comment"));

            String field = getField(columnName);
            column.setJavaField(field);
            column.setCjavaField(StringUtils.capitalize(field));
            column.setJdbcType(TypeUtil.getJdbcTypeName(dataType));
            column.setJavaType(TypeUtil.getJavaType(dataType));

            columnList.add(column);
        }

        return columnList;
    }

    private String getField(String column) {
        String[] columnSplit = column.split("_");

        StringBuffer field = new StringBuffer();

        for (int i = 0; i < columnSplit.length; i++) {
            if (i != 0) {
                field.append(StringUtils.capitalize(StringUtils.lowerCase(columnSplit[i])));
            } else {
                field.append(StringUtils.uncapitalize(StringUtils.lowerCase(columnSplit[i])));
            }
        }

        return field.toString();
    }
}
