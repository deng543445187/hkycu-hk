package com.huike.ycu.mybatis.service.impl;

import com.huike.ycu.mybatis.mapper.UmsAdminDao;
import com.huike.ycu.mybatis.model.UmsAdmin;
import com.huike.ycu.mybatis.result.CodeMsg;
import com.huike.ycu.mybatis.result.Result;
import com.huike.ycu.mybatis.service.AdminService;
import com.huike.ycu.mybatis.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UmsAdminDao adminDao;

    @Override
    public UmsAdmin login(UmsAdmin umsAdmin) {

        return this.adminDao.selectByUsernameAndPassword(umsAdmin);
    }

    @Override
    public void deleteByid(Long id) {

        this.adminDao.deleteByPrimaryKey(id);
    }

    @Override
    public int register(UmsAdmin umsAdmin) {

    return this.adminDao.insertSelective(umsAdmin);
    }

    @Override
    public Result<UmsAdmin> Login(UmsAdmin umsAdmin) {
        UmsAdmin admin = this.adminDao.selectByUsername(umsAdmin);
        if(ObjectUtils.isEmpty(admin)) {
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }
        String dbPwd = admin.getPassword();
        String saltDB = admin.getSalt();

        String calaPass = MD5Util.inputPassToDbPass(umsAdmin.getPassword(), saltDB);
        if(!StringUtils.equals(dbPwd, calaPass)) { // 密码不一致
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }
        // 返回的admin信息中不能有密码的信息，所以要将密码置空
        admin.setPassword(StringUtils.EMPTY);
        admin.setSalt(StringUtils.EMPTY);
        return Result.success(admin);
    }

}