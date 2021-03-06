/**
 * 文件名: HasAllRolesDirectiveModel.java
 * 版    权: Copyright © 2013 - 2018 CFNE, Inc. All Rights Reserved
 * 描    述: &lt;描述&gt;
 * 修改人: WeiQiang.Fan
 * 修改时间: 2018/8/19
 * 跟踪单号: &lt;跟踪单号&gt;
 * 修改单号: &lt;修改单号&gt;
 * 修改内容: &lt;修改内容&gt;
 */
package com.zerone.freemarker.shiro.model;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 功能描述 : freemarker自定义标签hasAllRoles
 * @author WeiQiangFan
 * @version [版本号,  2018/8/19]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
public class HasAllRolesDirectiveModel extends AbstractAttributeDirectiveModel
{
    /**
     * Model Name
     */
    public static final String MODEL_NAME = "hasAllRoles";

    /**
     * 权限控制标签渲染HTML
     *
     * @param environment Environment
     * @param params Element Parameters
     * @param models Template Models
     * @param body Template Directive Body
     * @throws TemplateException IO异常
     * @throws IOException 模板异常
     */
    @Override
    public void render(Environment environment, Map params, TemplateModel[] models, TemplateDirectiveBody body)
            throws TemplateException, IOException
    {
        String name = this.getParam(params, this.getAttrName());
        List<String> roles =Arrays.asList(name.split(DELIMITER));
        if (null != this.getSubject() && this.getSubject().hasAllRoles(roles))
        {
            if (LOGGER.isDebugEnabled())
            {
                LOGGER.debug("The subject has all role. Tag body will be evaluated");
            }
            this.render(environment, body);
        }
        else
        {
            if (LOGGER.isDebugEnabled())
            {
                LOGGER.debug("The subject has not all role. Tag body will not be evaluated");
            }
        }
    }
}