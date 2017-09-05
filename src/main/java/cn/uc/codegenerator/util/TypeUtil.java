package cn.uc.codegenerator.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class TypeUtil {
    private static Logger logger = Logger.getLogger(TypeUtil.class);

    private static Map<String, String> typeToName = new HashMap<String, String>();
    private static Map<String, String> typeToClass = new HashMap<String, String>();

    static {
        typeToName.put("bigint", "BIGINT");
        typeToName.put("bit", "BIT");
        typeToName.put("binary", "BINARY");
        typeToName.put("blob", "BLOB");
        typeToName.put("char", "CHAR");
        typeToName.put("datetime", "TIMESTAMP");
        typeToName.put("date", "DATE");
        typeToName.put("decimal", "DECIMAL");
        typeToName.put("double", "DOUBLE");
        typeToName.put("enum", "ENUM");
        typeToName.put("float", "FLOAT");
        typeToName.put("int", "INTEGER");
        typeToName.put("integer", "INTEGER");
        typeToName.put("longblob", "BLOB");
        typeToName.put("longtext", "LONGVARCHAR");
        typeToName.put("mediumblob", "BLOB");
        typeToName.put("mediumint", "INTEGER");
        typeToName.put("mediumtext", "LONGVARCHAR");
        typeToName.put("set", "SET");
        typeToName.put("smallint", "SMALLINT");
        typeToName.put("text", "LONGVARCHAR");
        typeToName.put("time", "TIME");
        typeToName.put("timestamp", "TIMESTAMP");
        typeToName.put("tinyblob", "BLOB");
        typeToName.put("tinyint", "TINYINT");
        typeToName.put("tinytext", "LONGVARCHAR");
        typeToName.put("varbinary", "VARBINARY");
        typeToName.put("varchar", "VARCHAR");
        typeToName.put("year", "DATE");

        typeToClass.put("bigint", "Long");
        typeToClass.put("binary", "byte[]");
        typeToClass.put("bit", "Boolean");
        typeToClass.put("blob", "byte[]");
        typeToClass.put("char", "String");
        typeToClass.put("datetime", "Date");
        typeToClass.put("date", "Date");
        typeToClass.put("decimal", "BigDecimal");
        typeToClass.put("double", "Double");
        typeToClass.put("enum", "String");
        typeToClass.put("float", "Float");
        typeToClass.put("int", "Integer");
        typeToClass.put("integer", "Integer");
        typeToClass.put("longblob", "byte[]");
        typeToClass.put("longtext", "String");
        typeToClass.put("mediumblob", "byte[]");
        typeToClass.put("mediumint", "Integer");
        typeToClass.put("mediumtext", "String");
        typeToClass.put("set", "String");
        typeToClass.put("smallint", "Integer");
        typeToClass.put("text", "String");
        typeToClass.put("time", "Time");
        typeToClass.put("timestamp", "Date");
        typeToClass.put("tinyblob", "byte[]");
        typeToClass.put("tinyint", "Integer");
        typeToClass.put("tinytext", "String");
        typeToClass.put("varbinary", "byte[]");
        typeToClass.put("varchar", "String");
        typeToClass.put("year", "Date");

    }

    public static String getJdbcTypeName(String jdbcType) {
        String answer = typeToName.get(jdbcType);
        if (answer == null) {
            answer = "varchar";
            logger.error("get JdbcTypeName failed for jdbcType " + jdbcType);
        }

        return answer;
    }

    public static String getJavaType(String jdbcType) {
        String answer = typeToClass.get(jdbcType);
        if (answer == null) {
            answer = "String";
            logger.error("get JavaType failed for jdbcType " + jdbcType);
        }

        return answer;
    }
}
