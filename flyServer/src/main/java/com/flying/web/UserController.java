package com.flying.web;

import com.flying.core.web.BaseController;
import com.flying.service.UserService;
import com.flying.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by giles on 2016/1/8.
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="getUsers",method= RequestMethod.GET)
    public @ResponseBody Map getUsers(String user_name){
        log.debug("init getUsers :{}",user_name);
        String s = "";
        Map e = new HashMap<String,String>();
        e.put("user_name",user_name);

        List list = userService.getUsers(e);

        log.debug("list {}",list);

        e.clear();
        e.put("List",list);

        log.debug("out getUsers");
        return e;
    }

    @RequestMapping("test")
    public @ResponseBody String test(){
        log.debug("init test");
        return "hello";
    }

    @RequestMapping("logout")
    public @ResponseBody String logout(){
        log.debug("init logout");
        return "logout";
    }

    @RequestMapping("login")
    public @ResponseBody String login(){
        log.debug("init login");
        return "logout";
    }

}
