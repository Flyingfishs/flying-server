package com.flying.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by giles on 2016/1/8.
 */
@Controller
public class TestRestController {

    //接收ajax请求
    //使用url的表达式动态传递参数
    //返回json
    @RequestMapping("/uri/{userId}")
    //多个url参数可以用多个注解和方法参数来接收
    public @ResponseBody Map uriTemplate(@PathVariable String userId){
        //也可以这么写
        //public @ResponseBody Map uriTemplate(@PathVariable("userId") String loginUserId){
        System.out.println("url的参数为:"+userId);
        Map<String, String> map = new HashMap<String, String>();
        map.put("user", userId);
        return map;
    }
}
