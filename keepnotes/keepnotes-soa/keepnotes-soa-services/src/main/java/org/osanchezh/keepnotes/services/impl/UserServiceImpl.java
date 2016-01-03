package org.osanchezh.keepnotes.services.impl;

import java.util.List;

import org.osanchezh.keepnotes.commons.to.KNTUserTO;
import org.osanchezh.keepnotes.model.KNTUserDO;
import org.osanchezh.keepnotes.persistence.LoggingTest;
import org.osanchezh.keepnotes.persistence.dao.KNTUserDAO;
import org.osanchezh.keepnotes.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.osanchezh.keepnotes.commons.exception.KeepNotesDatabaseException;


@Service("userService")
public class UserServiceImpl implements UserService{
	private static final Logger LOGGER =  LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	@Qualifier("kntuserDAO")
	private KNTUserDAO kntUserDAO;
	

    @Transactional(value = "dypTransactionManager", readOnly = true, propagation = Propagation.REQUIRED,
            timeout = 240, isolation = Isolation.READ_COMMITTED,
            rollbackFor = { KeepNotesDatabaseException.class })
	public List<KNTUserTO> loadUsers() {
		List<KNTUserDO> lstKNTUserDO= kntUserDAO.selectUsers();
		LOGGER.debug("lstKNTUserDO.size="+lstKNTUserDO.size());
		return null;
	}


	public KNTUserDAO getKntUserDAO() {
		return kntUserDAO;
	}

	public void setKntUserDAO(KNTUserDAO kntUserDAO) {
		this.kntUserDAO = kntUserDAO;
	}
}
