package com.huike.ycu.mybatis.test;

import com.huike.ycu.mybatis.mapper.UmsAdminDao;
import com.huike.ycu.mybatis.model.UmsAdmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTest {
    @Autowired
    private UmsAdminDao adminDao;

    @Test
    public  void  insertAdminTest(){
        UmsAdmin admin = new UmsAdmin();
        admin.setNickName("乐乐");
        admin.setCreateTime(new Date());
        admin.setPassword("123456");
        admin.setUsername("王五");

        this.adminDao.insertSelective(admin);

    }
    @Test
    public  void deleteAdmin(){

        this.adminDao.deleteByPrimaryKey(8l);
    }
   @Test
    public void  insertAdmin(){
        UmsAdmin umsAdmin = new UmsAdmin();
      umsAdmin.setUsername("马六");
      umsAdmin.setPassword("123456");
        this.adminDao.insertSelective(umsAdmin);
   }

}
