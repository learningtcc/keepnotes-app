package org.osanchezh.keepnotes.services.impl;

import org.osanchezh.keepnotes.persistence.dao.impl.user.UserDao;
import org.osanchezh.keepnotes.services.UserEntryService;
import org.osanchezh.keepnotes.soa.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userEntryService")
public class UserEntryServiceImpl implements UserEntryService {

	@Autowired
	@Qualifier("jpaUserDao")
	private UserDao jpaUserDao;
	
	public User findByName(String name) {
		return jpaUserDao.findByName(name);
	}
	
	public UserDao getJpaUserDao() {
		return jpaUserDao;
	}

	public void setJpaUserDao(UserDao jpaUserDao) {
		this.jpaUserDao = jpaUserDao;
	}



}
