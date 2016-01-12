package com.flying.dao;

import com.flying.core.persistence.annotation.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * Created by giles on 2016/1/8.
 */
@MyBatisDao
public interface UserDao {

    public List<?> getUsers(Map<String, ?> e);

}
