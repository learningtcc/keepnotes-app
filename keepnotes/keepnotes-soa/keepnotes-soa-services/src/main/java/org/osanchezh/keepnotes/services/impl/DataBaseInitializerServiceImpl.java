package org.osanchezh.keepnotes.services.impl;

import java.util.Date;

import org.osanchezh.keepnotes.commons.exception.KeepNotesDatabaseException;
import org.osanchezh.keepnotes.persistence.dao.impl.newsentry.NewsEntryDao;
import org.osanchezh.keepnotes.persistence.dao.impl.user.UserDao;
import org.osanchezh.keepnotes.services.DataBaseInitializerService;
import org.osanchezh.keepnotes.soa.model.entity.NewsEntry;
import org.osanchezh.keepnotes.soa.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Initialize the database with some test entries.
 * 
 * @author Philip W. Sorst <philip@sorst.net>
 */
@Service("dataBaseInitializerService")
public class DataBaseInitializerServiceImpl implements DataBaseInitializerService
{
	private static final Logger LOGGER =  LoggerFactory.getLogger(DataBaseInitializerServiceImpl.class);

	@Autowired
	@Qualifier("jpaNewsEntryDao")
	private NewsEntryDao jpaNewsEntryDao;

	@Autowired
	@Qualifier("jpaUserDao")
	private UserDao jpaUserDao;
	
	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;



/*
	public DataBaseInitializerServiceImpl(UserDao userDao, NewsEntryDao newsEntryDao, PasswordEncoder passwordEncoder)
	{
		this.jpaUserDao = userDao;
		this.jpaNewsEntryDao = newsEntryDao;
		this.passwordEncoder = passwordEncoder;
	}
*/
	@PostConstruct
	@Transactional(value = "keepnoteshtransactionManager", readOnly = false, propagation = Propagation.REQUIRED,
    timeout = 240, isolation = Isolation.DEFAULT,
    rollbackFor = { KeepNotesDatabaseException.class })
	public void initDataBase()
	{
		User userUser = new User("user", this.passwordEncoder.encode("user"));
		userUser.addRole("user");
		this.jpaUserDao.save(userUser);

		User adminUser = new User("admin", this.passwordEncoder.encode("admin"));
		adminUser.addRole("user");
		adminUser.addRole("admin");
		this.jpaUserDao.save(adminUser);

		long timestamp = System.currentTimeMillis() - 1000 * 60 * 60 * 24;
		for (int i = 0; i < 10; i++) {
			NewsEntry newsEntry = new NewsEntry();
			newsEntry.setContent("This is example content " + i);
			newsEntry.setDate(new Date(timestamp));
			this.jpaNewsEntryDao.save(newsEntry);
			timestamp += 1000 * 60 * 60;
			LOGGER.debug("--tiempo.insersion="+timestamp);
			
		}
		LOGGER.debug("cantidad="+jpaNewsEntryDao.findAll().size());
	}


	public UserDao getJpaUserDao() {
		return jpaUserDao;
	}


	public void setJpaUserDao(UserDao jpaUserDao) {
		this.jpaUserDao = jpaUserDao;
	}
}