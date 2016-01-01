package org.osanchezh.keepnotes.persistence.dao.impl;

import java.util.List;

import org.osanchezh.keepnotes.model.KNTUserDO;
import org.osanchezh.keepnotes.persistence.dao.KNTUserDAO;
import org.osanchezh.keepnotes.persistence.rowmapper.KNTUserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("kntuserDAO")
public class KNTUserDAOImpl implements KNTUserDAO {

	@Autowired
	@Qualifier("keepNotesUserNamedParameter")
    private NamedParameterJdbcTemplate keepNotesUserNamedParameter;
	
	


	public List<KNTUserDO> selectUsers() {
		return keepNotesUserNamedParameter.query("SELECT ID, NAME, PASSWORD, EMAIL FROM KNC_USER", new KNTUserRowMapper());
		
	}
  
	
	public NamedParameterJdbcTemplate getKeepNotesUserNamedParameter() {
		return keepNotesUserNamedParameter;
	}

	public void setKeepNotesUserNamedParameter(
			NamedParameterJdbcTemplate keepNotesUserNamedParameter) {
		this.keepNotesUserNamedParameter = keepNotesUserNamedParameter;
	}
	
}
