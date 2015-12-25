package cn.uc.codegenerator.module;

public class Column {
    
    private String columnName;
    private String columnType;
    private String dataType;
    private String comment;
    
    private String jdbcType;
    private String javaType;
    private String javaField;
    private String cjavaField;


    /**
     * @return the columnName
     */
    public String getColumnName() {
        return columnName;
    }
    /**
     * @param columnName the columnName to set
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    /**
     * @return the columnType
     */
    public String getColumnType() {
        return columnType;
    }
    /**
     * @param columnType the columnType to set
     */
    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
    /**
     * @return the dataType
     */
    public String getDataType() {
        return dataType;
    }
    /**
     * @param dataType the dataType to set
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }
    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    /**
     * @return the jdbcType
     */
    public String getJdbcType() {
        return jdbcType;
    }
    /**
     * @param jdbcType the jdbcType to set
     */
    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }
    /**
     * @return the javaType
     */
    public String getJavaType() {
        return javaType;
    }
    /**
     * @param javaType the javaType to set
     */
    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }
    /**
     * @return the javaField
     */
    public String getJavaField() {
        return javaField;
    }
    /**
     * @param javaField the javaField to set
     */
    public void setJavaField(String javaField) {
        this.javaField = javaField;
    }
    /**
     * @return the cjavaField
     */
    public String getCjavaField() {
        return cjavaField;
    }
    /**
     * @param cjavaField the cjavaField to set
     */
    public void setCjavaField(String cjavaField) {
        this.cjavaField = cjavaField;
    }
    
}
