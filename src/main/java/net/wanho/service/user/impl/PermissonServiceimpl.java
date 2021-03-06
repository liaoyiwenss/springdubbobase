package net.wanho.service.user.impl;

import net.wanho.mapper.PermissionMapper;
import net.wanho.pojo.Permission;
import net.wanho.service.user.PermissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PermissonServiceimpl implements PermissonService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int deleteByPrimaryKey(Long tid) {
        return permissionMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public int insert(Permission record) {
        return permissionMapper.insert(record);
    }

    @Override
    public int insertSelective(Permission record) {
        return permissionMapper.insertSelective(record);
    }

    @Override
    public Permission selectByPrimaryKey(Long tid) {
        return permissionMapper.selectByPrimaryKey(tid);
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String,Object>> selectAllPermission(){
        return permissionMapper.selectAllPermission();
    }



    @Override
    public List<Map<String,Object>> selectRoleandPermission(Long roleid) {
        return permissionMapper.selectcheckedPermission(roleid);
    }


}
