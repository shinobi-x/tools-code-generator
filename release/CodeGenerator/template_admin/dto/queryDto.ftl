package ${domain}.${model}.dto;

import cn.uc.appstore.cfbox.constants.BoxCommonConstant;
import ${domain}.${model}.model.${objectName};
import cn.uc.appstore.framework.utils.CommonUtils;

/**
 * ${objectName} 查询Dto
 *
 * @author ${author}
 *
 * @date ${createTime}
 */
public class ${objectName}QueryDto extends ${objectName} {

    /**
     * 当前页码
     */
    private Integer page;

    /**
     * 总行数
     */
    private Integer totalCount;

    /**
     * 起始行
     */
    private Integer offset;

    /**
     * 每页行数
     */
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
        int[] pager = CommonUtils.getPager(page, BoxCommonConstant.PAGE_SIZE);
        this.setOffset(pager[0]);
        this.setLimit(pager[1]);
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}
