/**
 * 文件名: ShiroDirectiveModelDialect.java
 * 版    权: Copyright © 2013 - 2018 CFNE, Inc. All Rights Reserved
 * 描    述: &lt;描述&gt;
 * 修改人: WeiQiang.Fan
 * 修改时间: 2018/8/19
 * 跟踪单号: &lt;跟踪单号&gt;
 * 修改单号: &lt;修改单号&gt;
 * 修改内容: &lt;修改内容&gt;
 */
package com.zerone.freemarker.shiro.dialect;

import com.zerone.freemarker.shiro.model.AuthenticatedDirectiveModel;
import com.zerone.freemarker.shiro.model.GuestDirectiveModel;
import com.zerone.freemarker.shiro.model.HasAllPermissionsDirectiveModel;
import com.zerone.freemarker.shiro.model.HasAllRolesDirectiveModel;
import com.zerone.freemarker.shiro.model.HasAnyPermissionsDirectiveModel;
import com.zerone.freemarker.shiro.model.HasAnyRolesDirectiveModel;
import com.zerone.freemarker.shiro.model.HasPermissionDirectiveModel;
import com.zerone.freemarker.shiro.model.HasRoleDirectiveModel;
import com.zerone.freemarker.shiro.model.LacksPermissionDirectiveModel;
import com.zerone.freemarker.shiro.model.LacksRoleDirectiveModel;
import com.zerone.freemarker.shiro.model.NotAuthenticatedDirectiveModel;
import com.zerone.freemarker.shiro.model.PrincipalDirectiveModel;
import com.zerone.freemarker.shiro.model.UserDirectiveModel;
import freemarker.template.SimpleHash;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 功能描述 : Shir标签声明
 * @author WeiQiangFan
 * @version [版本号,  2018/8/19]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
public class ShiroDirectiveModelDialect extends SimpleHash
{
    /**
     * 构造函数
     */
    public ShiroDirectiveModelDialect()
    {
        putAll(this.createStandardDirectiveModel());
    }

    /**
     * 创建所有标准的Shiro标签Model
     *
     * @return 所有标准的Shiro标签Model
     */
    public Map<String, Object> createStandardDirectiveModel()
    {
        Map<String, Object> models = new LinkedHashMap<String, Object>();
        models.put(AuthenticatedDirectiveModel.MODEL_NAME, new AuthenticatedDirectiveModel());
        models.put(GuestDirectiveModel.MODEL_NAME, new GuestDirectiveModel());
        models.put(HasAllRolesDirectiveModel.MODEL_NAME, new HasAllRolesDirectiveModel());
        models.put(HasAllPermissionsDirectiveModel.MODEL_NAME, new HasAllPermissionsDirectiveModel());
        models.put(HasAnyRolesDirectiveModel.MODEL_NAME, new HasAnyRolesDirectiveModel());
        models.put(HasAnyPermissionsDirectiveModel.MODEL_NAME, new HasAnyPermissionsDirectiveModel());
        models.put(HasRoleDirectiveModel.MODEL_NAME, new HasRoleDirectiveModel());
        models.put(HasPermissionDirectiveModel.MODEL_NAME, new HasPermissionDirectiveModel());
        models.put(LacksRoleDirectiveModel.MODEL_NAME, new LacksRoleDirectiveModel());
        models.put(LacksPermissionDirectiveModel.MODEL_NAME, new LacksPermissionDirectiveModel());
        models.put(NotAuthenticatedDirectiveModel.MODEL_NAME, new NotAuthenticatedDirectiveModel());
        models.put(PrincipalDirectiveModel.MODEL_NAME, new PrincipalDirectiveModel());
        models.put(UserDirectiveModel.MODEL_NAME, new UserDirectiveModel());
        return models;
    }
}