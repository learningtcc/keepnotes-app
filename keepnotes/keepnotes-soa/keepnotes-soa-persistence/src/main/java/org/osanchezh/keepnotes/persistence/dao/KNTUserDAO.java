package org.osanchezh.keepnotes.persistence.dao;

import java.util.List;

import org.osanchezh.keepnotes.model.KNTUserDO;

public interface KNTUserDAO {
  List<KNTUserDO> selectUsers();
}
