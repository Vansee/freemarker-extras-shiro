/**
 * 文件名: AbstractAttributeDirectiveModel.java
 * 版    权: Copyright © 2013 - 2018 CFNE, Inc. All Rights Reserved
 * 描    述: &lt;描述&gt;
 * 修改人: WeiQiang.Fan
 * 修改时间: 2018/8/19
 * 跟踪单号: &lt;跟踪单号&gt;
 * 修改单号: &lt;修改单号&gt;
 * 修改内容: &lt;修改内容&gt;
 */
package com.zerone.freemarker.shiro.model;

import freemarker.template.TemplateModelException;

import java.util.Map;

/**
 * 功能描述 : freemarker自定义标签有属性抽象类
 * @author WeiQiangFan
 * @version [版本号,  2018/8/19]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
public abstract class AbstractAttributeDirectiveModel extends AbstractDirectiveModel
{
    /** 权限分割符 */
    protected final String DELIMITER = ",";

    /** 标签属性名称 */
    private final String attrName;

    /**
     * 构造函数
     */
    public AbstractAttributeDirectiveModel()
    {
        this("name");
    }

    /**
     * 构造函数
     *
     * @param attrName 标签属性名称
     */
    public AbstractAttributeDirectiveModel(String attrName)
    {
        this.attrName = attrName;
    }

    /**
     * 验证标签是否合法
     *
     * @param params 参数信息
     * @throws TemplateModelException 模板异常
     */
    @Override
    public void verifyParameters(Map<String, Object> params) throws TemplateModelException
    {
        String permission = this.getParam(params, this.getAttrName());
        if (permission == null || permission.length() == 0)
        {
            throw new TemplateModelException("The 'name' tag attribute must be set.");
        }
    }

    /**
     * 获得标签属性名称
     *
     * @return 标签属性名称
     */
    public String getAttrName()
    {
        return this.attrName;
    }
}