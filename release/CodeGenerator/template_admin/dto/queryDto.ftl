package ${domain}.${model}.dto;

import ${domain}.${model}.model.${objectName};
import com.xiaoma.framework.common.page.PageDto;
import com.xiaoma.framework.common.page.PageUtil;

/**
 * ${objectName} 查询Dto
 *
 * @author ${author}
 *
 * @date ${createTime}
 */
public class ${objectName}QueryDto extends ${objectName} {
    
    private static final long serialVersionUID = 1L;
    
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
        int[] pager = PageUtil.getPager(page, PageDto.PAGE_SIZE);
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
