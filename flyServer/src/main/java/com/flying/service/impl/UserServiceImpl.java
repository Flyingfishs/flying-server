package com.flying.service.impl;

import com.flying.dao.UserDao;
import com.flying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by giles on 2016/1/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<?> getUsers(Map<String, ?> e) {
        return userDao.getUsers(e);
    }
}
