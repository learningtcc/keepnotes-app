package org.osanchezh.keepnotes.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.osanchezh.keepnotes.commons.to.KNTUserTO;
import org.osanchezh.keepnotes.model.KNTUserDO;
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
import org.osanchezh.keepnotes.commons.exception.KeepNotesServicesException;


@Service("userService")
public class UserServiceImpl implements UserService{
	private static final Logger LOGGER =  LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	@Qualifier("kntuserDAO")
	private KNTUserDAO kntUserDAO;
	
	@Autowired
	@Qualifier("dozerBean")
    private DozerBeanMapperFactoryBean dozerBean;





	@Transactional(value = "keepNotesUserTransactionManager", readOnly = true, propagation = Propagation.REQUIRED,
            timeout = 240, isolation = Isolation.READ_COMMITTED,
            rollbackFor = { KeepNotesDatabaseException.class })
	public List<KNTUserTO> loadUsers() throws KeepNotesServicesException  {
		Mapper mapper=null;
		List<KNTUserTO> lstKNTUserTO = new ArrayList<KNTUserTO>();

		try {
			mapper = (Mapper) dozerBean.getObject();

		List<KNTUserDO> lstKNTUserDO= kntUserDAO.selectUsers();
		for(KNTUserDO kntUserDO: lstKNTUserDO){
			KNTUserTO kntUserTO = new KNTUserTO();
			mapper.map(kntUserDO, kntUserTO);
			LOGGER.debug("CONVERT="+kntUserTO.toString());
			lstKNTUserTO.add(kntUserTO);
		}
		LOGGER.debug("lstKNTUserDO.size="+lstKNTUserDO.size());
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage(),exception);
		}
		return lstKNTUserTO;
	}


	public DozerBeanMapperFactoryBean getDozerBean() {
		return dozerBean;
	}



	public void setDozerBean(DozerBeanMapperFactoryBean dozerBean) {
		this.dozerBean = dozerBean;
	}

	public KNTUserDAO getKntUserDAO() {
		return kntUserDAO;
	}

	public void setKntUserDAO(KNTUserDAO kntUserDAO) {
		this.kntUserDAO = kntUserDAO;
	}
	

}
