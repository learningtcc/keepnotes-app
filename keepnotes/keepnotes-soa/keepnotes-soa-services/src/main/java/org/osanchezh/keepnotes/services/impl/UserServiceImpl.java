package org.osanchezh.keepnotes.services.impl;

import java.util.List;

import org.osanchezh.keepnotes.commons.to.KNTUserTO;
import org.osanchezh.keepnotes.model.KNTUserDO;
import org.osanchezh.keepnotes.persistence.dao.KNTUserDAO;
import org.osanchezh.keepnotes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("kntuserDAO")
	private KNTUserDAO kntUserDAO;
	

	public List<KNTUserTO> loadUsers() {
		List<KNTUserDO> lstKNTUserDO= kntUserDAO.selectUsers();
		return null;
	}


	public KNTUserDAO getKntUserDAO() {
		return kntUserDAO;
	}

	public void setKntUserDAO(KNTUserDAO kntUserDAO) {
		this.kntUserDAO = kntUserDAO;
	}
}
