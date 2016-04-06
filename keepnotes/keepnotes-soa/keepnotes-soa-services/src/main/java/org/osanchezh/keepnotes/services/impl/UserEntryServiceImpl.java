package org.osanchezh.keepnotes.services.impl;

import java.util.List;

import org.osanchezh.keepnotes.commons.exception.KeepNotesDatabaseException;
import org.osanchezh.keepnotes.persistence.dao.impl.user.UserDao;
import org.osanchezh.keepnotes.services.UserEntryService;
import org.osanchezh.keepnotes.soa.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userEntryService")
public class UserEntryServiceImpl implements UserEntryService {

	@Autowired
	@Qualifier("jpaUserDao")
	private UserDao jpaUserDao;
	
	@Transactional(value = "keepnoteshtransactionManager", readOnly = true, propagation = Propagation.REQUIRED,
            timeout = 240, isolation = Isolation.DEFAULT,
            rollbackFor = { KeepNotesDatabaseException.class })
	public User findByName(String name) {
		return jpaUserDao.findByName(name);
	}
	
	@Transactional(value = "keepnoteshtransactionManager", readOnly = true, propagation = Propagation.REQUIRED,
            timeout = 240, isolation = Isolation.DEFAULT,
            rollbackFor = { KeepNotesDatabaseException.class })
	public List<User> findAll(){
		return jpaUserDao.findAll();
	}    
	
	public UserDao getJpaUserDao() {
		return jpaUserDao;
	}

	public void setJpaUserDao(UserDao jpaUserDao) {
		this.jpaUserDao = jpaUserDao;
	}

}
