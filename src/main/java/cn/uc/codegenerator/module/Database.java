package cn.uc.codegenerator.module;

import java.util.List;

public class Database {

    private String rootDirCode;
    private String rootDirMapper;
    private String domain;
    private String model;
    private String author;
    private String projectType;
    private String createTime;
    private List<Table> tableList;

    public String getRootDirCode() {
        return rootDirCode;
    }

    public void setRootDirCode(String rootDirCode) {
        this.rootDirCode = rootDirCode;
    }

    public String getRootDirMapper() {
        return rootDirMapper;
    }

    public void setRootDirMapper(String rootDirMapper) {
        this.rootDirMapper = rootDirMapper;
    }

    /**
     * @return the domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * @param domain
     *            the domain to set
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
     * @param model
     *            the model to set
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
     * @param author
     *            the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the projectType
     */
    public String getProjectType() {
        return projectType;
    }

    /**
     * @param projectType the projectType to set
     */
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    /**
     * @return the createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     *            the createTime to set
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the tableList
     */
    public List<Table> getTableList() {
        return tableList;
    }

    /**
     * @param tableList
     *            the tableList to set
     */
    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }

}
