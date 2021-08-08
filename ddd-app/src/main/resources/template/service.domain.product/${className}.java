<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign hasDateType = false>
package ${basepackage}.model;

<#list table.columns as column>
<#if column.isDateTimeColumn>
    <#assign hasDateType = true>
</#if>
</#list>
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
<#if hasDateType>
import java.util.Date;
</#if>

<#include "/java_imports.include">

/**
 * ${table.remarks } 实体类
 * @author ${author}
 * @date ${.now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Getter
@Setter
public class ${className} {

    <#list table.columns as column>
    /**
     * ${column.columnAlias!}
     */
    private ${column.simpleJavaType} ${column.columnNameLower};
    </#list>
}