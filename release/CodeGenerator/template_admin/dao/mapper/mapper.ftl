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
    
    <select id="get${objectName}CountByCondition" parameterType="${domain}.${model}.dto.${objectName}QueryDto" resultType="java.lang.Integer">
        select count(*) from ${tableName} 
        where 1 
        <#if columnList??>
        <#list columnList as item>
        <if test="${item.javaField} != null">
            and ${item.columnName} = ${"#{"}${item.javaField}${"}"} 
        </if>
        </#list>
        </#if>
        <#if containsIsEnable==true> and is_enable = 1 </#if>
    </select>
    
    <select id="get${objectName}ListByCondition" parameterType="${domain}.${model}.dto.${objectName}QueryDto" resultMap="${objectName}Mapper">
        select <include refid="Base_Column_List" /> from ${tableName} 
        where 1 
        <#if columnList??>
        <#list columnList as item>
        <if test="${item.javaField} != null">
            and ${item.columnName} = ${"#{"}${item.javaField}${"}"} 
        </if>
        </#list>
        </#if>
        <#if containsIsEnable==true> and is_enable = 1 </#if>
        <#if containsUpdateTime==true>order by update_time desc </#if>
        limit ${"#{"}offset${"}"},${"#{"}limit${"}"} 
    </select>
    
    <select id="get${objectName}ById" resultMap="${objectName}Mapper" parameterType="java.lang.Integer" >
        select <include refid="Base_Column_List" /> from ${tableName} where id = ${"#{"}id${"}"}
    </select>
    
    <select id="getAll${objectName}List" resultMap="${objectName}Mapper">
        select <include refid="Base_Column_List" /> from ${tableName} <#if containsIsEnable==true>where is_enable = 1 </#if>
    </select>
    
    <insert id="save" parameterType="${domain}.${model}.model.${objectName}" useGeneratedKeys="true" keyProperty="id" >
        insert into ${tableName} (<include refid="Base_Column_List" />)
        values (
        <#if columnList??>
        <#list columnList as item>
        ${"#{"}${item.javaField},jdbcType=${item.jdbcType}${"}"}<#if item_has_next>,</#if>
        </#list>
        </#if>)
    </insert>
    
    <update id="update" parameterType="${domain}.${model}.model.${objectName}" >
        update ${tableName}
        <set>
        <#if columnList??>
        <#list columnList as item>
            ${item.columnName} = ${"#{"}${item.javaField}${"}"}<#if item_has_next>,</#if>
        </#list>
        </#if>
        </set>
        where id = ${"#{"}id${"}"}
    </update>
    
    <#if containsIsEnable==true>
    <update id="delete" parameterType="java.lang.Integer" >
        update ${tableName} set is_enable=0 where id = ${"#{"}id${"}"}
    </update>
    <#else>
    <delete id="deleteById" parameterType="java.lang.Integer" >
        delete from ${tableName} where id = ${"#{"}id${"}"}
    </delete>
    </#if>
    
</mapper>