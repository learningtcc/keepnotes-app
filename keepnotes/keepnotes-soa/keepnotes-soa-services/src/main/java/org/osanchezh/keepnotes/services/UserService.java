package org.osanchezh.keepnotes.services;

import java.util.List;

import org.osanchezh.keepnotes.commons.to.KNTUserTO;

public interface UserService {
  List<KNTUserTO> loadUsers();
}
