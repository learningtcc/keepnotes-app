package org.osanchezh.keepnotes.persistence.dao;

import java.util.List;

import org.osanchezh.keepnotes.soa.model.entity.Entity;



public interface Dao<T extends Entity, I>
{

	List<T> findAll();


	T find(I id);


	T save(T newsEntry);


	void delete(I id);

}