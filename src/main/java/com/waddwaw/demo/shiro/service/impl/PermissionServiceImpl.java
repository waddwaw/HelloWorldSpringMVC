package com.waddwaw.demo.shiro.service.impl;

import com.waddwaw.demo.shiro.dao.PermissionMapper;
import com.waddwaw.demo.shiro.model.Permission;
import com.waddwaw.demo.shiro.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 权限Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午12:05:03
 */
@Service
public class PermissionServiceImpl  implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    public List<Permission> selectPermissionsByRoleId(Long roleId) {
        return permissionMapper.selectPermissionsByRoleId(roleId);
    }
}
