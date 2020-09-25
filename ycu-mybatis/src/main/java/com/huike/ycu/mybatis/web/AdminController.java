package com.huike.ycu.mybatis.web;

import com.huike.ycu.mybatis.model.UmsAdmin;
import com.huike.ycu.mybatis.result.Result;
import com.huike.ycu.mybatis.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
       return "Hello,欢迎！！！";

    }
    @RequestMapping("login")
    @ResponseBody
    public ModelAndView login(Model model, String username, String password){
      ModelAndView mav = new ModelAndView();
        UmsAdmin admin = new UmsAdmin();
        admin.setUsername(username);
        UmsAdmin dbAdmin = this.adminService.login(admin);
        if(ObjectUtils.isEmpty(dbAdmin)) {
            mav.setStatus(HttpStatus.OK);
            mav.addObject("msg", "该用户不存在");
            return mav;
        }

        if(password.equals( dbAdmin.getPassword() ) ) {
            mav.addObject("admin", dbAdmin);
        }
        return mav;
    }
    @RequestMapping("/register")
    @ResponseBody
    public ModelAndView register(Model model, String username, String password,String password2){
        ModelAndView mvc = new ModelAndView();
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername(username);
        umsAdmin.setPassword(password);

        if(username !=null &&  password.equals(password2)){

            this.adminService.register(umsAdmin);
        }else if(username == null){
            mvc.setStatus(HttpStatus.OK);
            mvc.addObject("msg","账号不能为空");
            return mvc;
        } else if(password == null || password2 == null){
            mvc.setStatus(HttpStatus.OK);
        mvc.addObject("msg","密码不能为空");
           return mvc;
        }else{
            mvc.setStatus(HttpStatus.OK);
            mvc.addObject("msg","两次密码不一致");
            return mvc;
        }

        return mvc;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public void deleteAdmin(Long id){

        this.adminService.deleteByid(id);

    }
    @RequestMapping("updata")
    @ResponseBody
    public void updataAdmin(){


    }

    @PostMapping("/Login")
    @ResponseBody
    public Result<UmsAdmin> Login(Model model, String username, String password) {
        UmsAdmin admin = new UmsAdmin();
        admin.setUsername(username);
        admin.setPassword(password);
        Result<UmsAdmin> Login = this.adminService.Login(admin);

        return Login;
    }

}
