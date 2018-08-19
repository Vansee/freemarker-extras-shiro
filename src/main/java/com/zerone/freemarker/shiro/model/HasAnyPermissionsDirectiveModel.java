/**
 * 文件名: HasAnyPermissionsDirectiveModel.java
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

import java.io.IOException;
import java.util.Map;

/**
 * 功能描述 : freemarker自定义标签hasAnyPermissions
 * @author WeiQiangFan
 * @version [版本号,  2018/8/19]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
public class HasAnyPermissionsDirectiveModel extends AbstractAttributeDirectiveModel
{
    /**
     * Model Name
     */
    public static final String MODEL_NAME = "hasAnyPermissions";

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
        String[] permissions = name.split(DELIMITER);
        boolean permitted = false;
        for (String permission : permissions)
        {
            if (null != this.getSubject() && this.getSubject().isPermitted(permission))
            {
                permitted = true;
                break;
            }
        }

        if (permitted)
        {
            if (LOGGER.isDebugEnabled())
            {
                LOGGER.debug("The subject is any permitted. Tag body will be evaluated.");
            }
            this.render(environment, body);
        }
        else
        {
            if (LOGGER.isDebugEnabled())
            {
                LOGGER.debug("The subject is not any permitted. Tag body will not be evaluated.");
            }
        }
    }
}