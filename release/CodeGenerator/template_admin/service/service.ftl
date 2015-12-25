package ${domain}.${model}.service;

import java.util.List;
import ${domain}.${model}.dto.${objectName}QueryDto;
import ${domain}.${model}.model.${objectName};

/**
 * ${objectName} Service 接口
 * 
 * @author ${author}
 * 
 * @date ${createTime}
 */
public interface ${objectName}Service {

    /**
     * 根据条件查询${objectName}数量
     
     * @param ${objectName}QueryDto
     *
     * @return 满足查询条件的记录数量
     */
    public Integer get${objectName}CountByCondition(${objectName}QueryDto ${lobjectName}QueryDto);
    
    /**
     * 根据条件分页查询${objectName}列表
     *
     * @param ${objectName}QueryDto
     *
     * @return 满足查询条件的${objectName}列表
     */
    public List<${objectName}> get${objectName}ListByCondition(${objectName}QueryDto ${lobjectName}QueryDto);
    
    /**
     * 根据Id获取${objectName}
     * 
     * @param id
     *
     * @return ${objectName}对象
     */
    public ${objectName} get${objectName}ById(Integer id);

    /**
     * 获取所有${objectName}列表
     * 
     * @return ${objectName}列表
     */
    public List<${objectName}> getAll${objectName}List();

    /**
     * 新增${objectName}
     * 
     * @param ${lobjectName}
     *
     * @return void
     */
    public void save(${objectName} ${lobjectName});

    /**
     * 更新${objectName}
     * 
     * @param ${lobjectName}
     *
     * @return void
     */
    public void update(${objectName} ${lobjectName});

    /**
     * 根据Id删除${objectName}
     * 
     * @param id
     *
     * @return void
     */
    public void deleteById(Integer id);

}
