package com.huike.ycu.mybatis.mapper;

import com.huike.ycu.mybatis.model.UmsAdmin;

public interface UmsAdminDao {
    /*根据id删除*/
    int deleteByPrimaryKey(Long id);
  /*添加*/
    int insert(UmsAdmin record);
/*添加admin*/
    int insertSelective(UmsAdmin record);
/*  根据主键查询*/
    UmsAdmin selectByPrimaryKey(Long id);
/*更新*/
    int updateByPrimaryKeySelective(UmsAdmin record);

    int updateByPrimaryKey(UmsAdmin record);

    /*根据用户名和密码进行查询*/
    UmsAdmin selectByUsernameAndPassword(UmsAdmin umsAdmin);

    UmsAdmin selectByUsername(UmsAdmin umsAdmin);

}