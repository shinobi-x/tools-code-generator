package ${domain}.${model}.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ${domain}.${model}.dao.${objectName}Mapper;
import ${domain}.${model}.model.${objectName};
import ${domain}.${model}.service.${objectName}Service;

/**
 * ${objectName} Service 实现类
 * 
 * @author ${author}
 * 
 * @date ${createTime}
 * 
 */
@Service("${lobjectName}Service")
public class ${objectName}ServiceImpl implements ${objectName}Service {

    @Resource
    private ${objectName}Mapper ${lobjectName}Mapper;
    
}
