package com.core.application.dao;

import org.springframework.stereotype.Repository;

import com.core.application.base.AbstractHibernateDao;
import com.core.application.model.User;

@Repository
public class UserDaoImpl extends AbstractHibernateDao<User> implements UserDao{

}
