package org.layz.hx.spring.jdbc.repository;

import java.io.Serializable;
import java.util.List;

import org.layz.hx.core.pojo.Page;
import org.layz.hx.core.pojo.Pageable;

public interface BaseDao<T> extends Serializable {
	String FIND_BY_ID = "findById";
	String FIND_BY_IDS = "findByIds";
	String FIND_BY_ENTITY = "findByEntity";
	String FIND_ALL = "findAll";
	String DELETE_BY_ENTITY = "deleteByEntity";
	String DELETE_BY_ID = "deleteById";
	String COUNT_BY_ENTITY = "countByEntity";
	String PERSIST_ENTITY = "persistEntity";
	String UPDATE = "update";
	/**
	 * @param t
	 * @return
	 */
	Integer persistEntity(T t);
	/**
	 * 
	 * @param t
	 * @return
	 */
	Integer deleteByEntity(T t);
	/**
	 *
	 * @param id
	 * @return
	 */
	Integer deleteById(Long id);
	/**
	 * _更新所有字段
	 * @param t
	 * @return
	 */
	Integer update(T t);
	/**
	 * _更新非空字段
	 * @param t
	 * @return
	 */
	Integer updateNotnull(T t);
	/**
	 * _根据id查询
	 * @param id
	 * @return
	 */
	T findById(Long id);
	/**
	 * _根据ids查询
	 * @param ids
	 * @return
	 */
	List<T> findByIds(List<Long> ids);
	/**
	 * _根据条件查查
	 * @param t
	 * @return
	 */
	List<T> findByEntity(T t);
	
	/**
	 * _根据条件查查
	 * @param t
	 * @return
	 */
	List<T> findByEntity(T t, String orderBy);
	/**
	 * _分页查询
	 * @param t
	 * @param pageable
	 * @return
	 */
	Page<T> findPage(T t, Pageable pageable);

	/**
	 * @return
	 */
    List<T> findAll();
}
