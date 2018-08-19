/**
 * 文件名: AbstractDirectiveModel.java
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
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * 功能描述 : freemarker自定义标签抽象类
 * @author WeiQiangFan
 * @version [版本号,  2018/8/19]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
public abstract class AbstractDirectiveModel implements TemplateDirectiveModel
{
    /** LOGGER */
    protected Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(Environment environment, Map params, TemplateModel[] models, TemplateDirectiveBody body)
            throws TemplateException, IOException
    {
        this.verifyParameters(params);
        this.render(environment, params, models, body);
    }

    /**
     * 渲染标签内容
     *
     * @param env Environment
     * @param body Template Directive Body
     * @throws IOException IO异常
     * @throws TemplateException 模板异常
     */
    protected void render(Environment env, TemplateDirectiveBody body) throws IOException, TemplateException
    {
        if (body != null)
        {
            body.render(env.getOut());
        }
    }

    /**
     * 获得参数的值
     *
     * @param params 参数信息
     * @param name 参数名称
     * @return 参数值
     */
    protected String getParam(Map<String, Object> params, String name)
    {
        Object value = params.get(name);
        if (value instanceof SimpleScalar)
        {
            return ((SimpleScalar) value).getAsString();
        }
        return null;
    }

    /**
     * 获得当前登录对象
     *
     * @return 当前登录对象
     */
    protected Subject getSubject()
    {
        return SecurityUtils.getSubject();
    }

    /**
     * 验证标签是否合法
     *
     * @param params 参数信息
     * @throws TemplateModelException 模板异常
     */
    public abstract void verifyParameters(Map<String, Object> params) throws TemplateModelException;

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
    public abstract void render(Environment environment, Map params, TemplateModel[] models, TemplateDirectiveBody body)
            throws TemplateException, IOException;
}