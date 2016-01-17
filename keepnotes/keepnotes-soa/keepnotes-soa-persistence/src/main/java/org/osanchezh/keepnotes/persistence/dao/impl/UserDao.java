package org.osanchezh.keepnotes.persistence.dao.impl;


import org.osanchezh.keepnotes.persistence.dao.Dao;
import org.osanchezh.keepnotes.soa.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserDao extends Dao<User, Long>, UserDetailsService
{

	User findByName(String name);

}