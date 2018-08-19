/**
 * 文件名: PrincipalDirectiveModel.java
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

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.util.Map;

/**
 * 功能描述 : freemarker自定义标签principal
 * @author WeiQiangFan
 * @version [版本号,  2018/8/19]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
public class PrincipalDirectiveModel extends AbstractElementDirectiveModel
{
    /**
     * Model Name
     */
    public static final String MODEL_NAME = "principal";

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
        if (null != this.getSubject())
        {
            String result = "";
            Object principal;
            String type = getParam(params, "type");
            if (null == type)
            {
                principal = getSubject().getPrincipal();
            }
            else
            {
                principal = this.getPrincipalFromClassName(params);
            }

            if (null != principal)
            {
                String property = getParam(params, "property");
                if (null == property)
                {
                    result = principal.toString();
                }
                else
                {
                    result = this.getPropertyFromPrincipal(principal, property);
                }
            }

            if (LOGGER.isDebugEnabled())
            {
                LOGGER.debug("The Subject does not exist or does not have a known identity (aka 'principal'). Tag body will be evaluated.");
            }

            if (null != result)
            {
                environment.getOut().write(result);

            }
        }
        else
        {
            if (LOGGER.isDebugEnabled())
            {
                LOGGER.debug("Subject exists or has a known identity (aka 'principal'). Tag body will not be evaluated.");
            }
        }
    }

    /**
     * 获得存储的信息对象
     *
     * @param params 参数信息
     * @return 信息对象
     */
    private Object getPrincipalFromClassName(Map<String, Object> params)
    {
        String type = getParam(params, "type");
        try
        {
            Class<?> clazz = Class.forName(type);
            return getSubject().getPrincipals().oneByType(clazz);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.error("Unable to find class for name ['" + type + "']", e);
        }
        return null;
    }

    /**
     * 获得用户存储信息对象对应属性的值
     *
     * @param principal 用户存储信息对象
     * @param property 属性名称
     * @return 属性值
     * @throws TemplateModelException 模板异常
     */
    private String getPropertyFromPrincipal(Object principal, String property) throws TemplateModelException
    {
        try
        {
            BeanInfo beanInfo = Introspector.getBeanInfo(principal.getClass());
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : descriptors)
            {
                if (descriptor.getName().equals(property))
                {
                    Object value = descriptor.getReadMethod().invoke(principal, (Object[]) null);
                    return String.valueOf(value);
                }
            }
            throw new TemplateModelException(
                    "Property [" + property + "] not found in principal of type [" + principal.getClass().getName() + "]");
        }
        catch (Exception e)
        {
            throw new TemplateModelException(
                    "Error reading property [" + property + "] from principal of type [" + principal.getClass().getName() + "]", e);
        }
    }
}