package org.osanchezh.keepnotes.services;

import java.util.List;

import org.osanchezh.keepnotes.soa.model.entity.User;

public interface UserEntryService {
	User findByName(String name);
	List<User> findAll();
}
