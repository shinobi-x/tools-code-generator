package cn.uc.codegenerator.module;

import java.util.List;

public class Table {

    private String domain;
    
    private String model;
    
    private String author;
    
    private String createTime;
    
    private String tableName;

    private String objectName;
    
    private String lobjectName;
    
    private String comment;
    
    private List<Column> columnList;
    
    private boolean containsIsEnable;
    
    private boolean containsUpdateTime;

    /**
     * @return the domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * @param domain the domain to set
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @param tableName the tableName to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * @return the objectName
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * @param objectName the objectName to set
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    /**
     * @return the lobjectName
     */
    public String getLobjectName() {
        return lobjectName;
    }

    /**
     * @param lobjectName the lobjectName to set
     */
    public void setLobjectName(String lobjectName) {
        this.lobjectName = lobjectName;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment
     *            the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the columnList
     */
    public List<Column> getColumnList() {
        return columnList;
    }

    /**
     * @param columnList the columnList to set
     */
    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }

    /**
     * @return the containsIsEnable
     */
    public boolean isContainsIsEnable() {
        return containsIsEnable;
    }

    /**
     * @param containsIsEnable the containsIsEnable to set
     */
    public void setContainsIsEnable(boolean containsIsEnable) {
        this.containsIsEnable = containsIsEnable;
    }

    /**
     * @return the containsUpdateTime
     */
    public boolean isContainsUpdateTime() {
        return containsUpdateTime;
    }

    /**
     * @param containsUpdateTime the containsUpdateTime to set
     */
    public void setContainsUpdateTime(boolean containsUpdateTime) {
        this.containsUpdateTime = containsUpdateTime;
    }

}
