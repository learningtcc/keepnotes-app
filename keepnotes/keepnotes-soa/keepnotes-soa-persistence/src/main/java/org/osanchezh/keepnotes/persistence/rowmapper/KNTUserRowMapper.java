package org.osanchezh.keepnotes.persistence.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.osanchezh.keepnotes.model.KNTUserDO;
import org.springframework.jdbc.core.RowMapper;

public class KNTUserRowMapper implements RowMapper<KNTUserDO> {

	public KNTUserDO mapRow(ResultSet arg0, int arg1) throws SQLException {
		KNTUserDO kntUserDO = new KNTUserDO();
		kntUserDO.setId(arg0.getInt("ID"));
		kntUserDO.setEmail(arg0.getString("EMAIL"));
		kntUserDO.setName(arg0.getString("NAME"));
		kntUserDO.setPassword(arg0.getString("PASSWORD"));
		return kntUserDO;
	}

}
