package org.osanchezh.keepnotes.services;

import org.osanchezh.keepnotes.soa.model.entity.User;

public interface UserEntryService {
	User findByName(String name);
}
