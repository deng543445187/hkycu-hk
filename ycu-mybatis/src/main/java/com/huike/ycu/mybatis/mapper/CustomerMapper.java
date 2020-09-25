package com.huike.ycu.mybatis.mapper;

import com.huike.ycu.mybatis.model.Customer;

import java.util.List;

public interface CustomerMapper {
     /*查询所有客户*/
    List<Customer> getAll();
    /*查询单个客户*/
    Customer getOne(Long id);
    /*增加客户*/
    void insert(Customer customer);
    /*更新客户*/
    void update(Customer customer);
    /*删除客户*/
    void delete(Long id);
}
