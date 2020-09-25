package com.huike.ycu.mybatis.service;

import com.huike.ycu.mybatis.model.UmsAdmin;
import com.huike.ycu.mybatis.result.Result;

public interface AdminService {
    /*登录*/
    UmsAdmin login(UmsAdmin umsAdmin);

    void deleteByid(Long id);

    int  register(UmsAdmin umsAdmin);

    Result<UmsAdmin> Login(UmsAdmin umsAdmin);




}
