package ${domain}.${model}.model;

import java.io.Serializable;

/**
 * ${comment}
 *
 * @author ${author}
 *
 * @date ${createTime}
 */
public class ${objectName} implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    <#if columnList??>
    <#list columnList as item>

    /**
     * <#if item.comment??>${item.comment}</#if>
     */
    private <#if item.javaType??>${item.javaType}</#if> <#if item.javaField??>${item.javaField}</#if>;
    </#list>

    <#list columnList as item>
    public <#if item.javaType??>${item.javaType}</#if> get<#if item.cjavaField??>${item.cjavaField}</#if>() {
        return <#if item.javaField??>${item.javaField}</#if>;
    }

    public void set<#if item.cjavaField??>${item.cjavaField}</#if>(<#if item.javaType??>${item.javaType}</#if> <#if item.javaField??>${item.javaField}</#if>) {
        this.${item.javaField} = <#if item.javaField??>${item.javaField}</#if>;
    }

    </#list>
    </#if>
}
