package ${domain}.${model}.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ${domain}.${model}.dao.${objectName}Mapper;
import ${domain}.${model}.dto.${objectName}QueryDto;
import ${domain}.${model}.model.${objectName};
import ${domain}.${model}.service.${objectName}Service;

/**
 * ${objectName} Service 实现类
 * 
 * @author ${author}
 * 
 * @date ${createTime}
 */
@Service("${lobjectName}Service")
public class ${objectName}ServiceImpl implements ${objectName}Service {

    @Resource
    private ${objectName}Mapper ${lobjectName}Mapper;

    @Override
    public Integer get${objectName}CountByCondition(${objectName}QueryDto ${lobjectName}QueryDto) {
        return ${lobjectName}Mapper.get${objectName}CountByCondition(${lobjectName}QueryDto);
    }

    @Override
    public List<${objectName}> get${objectName}ListByCondition(${objectName}QueryDto ${lobjectName}QueryDto) {
        return ${lobjectName}Mapper.get${objectName}ListByCondition(${lobjectName}QueryDto);
    }

    @Override
    public ${objectName} get${objectName}ById(Integer id) {
        return ${lobjectName}Mapper.get${objectName}ById(id);
    }

    @Override
    public List<${objectName}> getAll${objectName}List() {
        return ${lobjectName}Mapper.getAll${objectName}List();
    }
    
    @Override
    public void save(${objectName} ${lobjectName}) {
        ${lobjectName}Mapper.save(${lobjectName});
    }

    @Override
    public void update(${objectName} ${lobjectName}) {
        ${lobjectName}Mapper.update(${lobjectName});
    }

    @Override
    public void deleteById(Integer id) {
        ${lobjectName}Mapper.deleteById(id);
    }

}
