<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${domain}.${model}.dao.${objectName}Mapper" >
    <resultMap id="${objectName}Mapper" type="${domain}.${model}.model.${objectName}" >
    <#if columnList??>
    <#list columnList as item>
        <<#if item.columnName=='id'>id</#if><#if item.columnName!='id'>result</#if> column="${item.columnName}" property="${item.javaField}" jdbcType="${item.jdbcType}" />
    </#list>
    </#if>
    </resultMap>
    
    <sql id="Base_Column_List" >
        <#if columnList??>
        <#list columnList as item>
        ${item.columnName}<#if item_has_next>,</#if>
        </#list>
        </#if>
    </sql>
    
</mapper>