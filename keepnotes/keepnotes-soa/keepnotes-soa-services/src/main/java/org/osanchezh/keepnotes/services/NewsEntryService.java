package org.osanchezh.keepnotes.services;

import java.util.List;


import org.osanchezh.keepnotes.soa.model.entity.NewsEntry;


public interface NewsEntryService {
	List<NewsEntry> list();
	NewsEntry read(Long id);
	NewsEntry create(NewsEntry newsEntry);
	NewsEntry update(Long id, NewsEntry newsEntry);
	void delete(Long id);
}
