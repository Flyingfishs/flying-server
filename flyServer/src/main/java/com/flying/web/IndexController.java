package com.flying.web;

import com.flying.core.web.BaseController;
import com.flying.service.UserService;
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
@RequestMapping
public class IndexController extends BaseController {

    @RequestMapping("index")
    public String index(){
        log.debug("init index");
        return "index";
    }

}
