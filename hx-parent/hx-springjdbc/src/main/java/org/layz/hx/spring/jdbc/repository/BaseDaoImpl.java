package org.layz.hx.spring.jdbc.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.layz.hx.core.entity.AutoLongBaseEntity;
import org.layz.hx.core.pojo.Page;
import org.layz.hx.core.pojo.Pageable;
import org.layz.hx.spring.jdbc.exception.HxJdbcRuntimeException;
import org.layz.hx.spring.jdbc.factory.RowMapperFactory;
import org.layz.hx.spring.jdbc.factory.SqlBuildFactory;
import org.layz.hx.spring.jdbc.pojo.SqlParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BaseDaoImpl<T> extends JdbcDaoSupport implements BaseDao<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5979642965053611703L;
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseDaoImpl.class);
	protected Class<T> clazz;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private RowMapperFactory rowMapperFactory;
	@Autowired
	private SqlBuildFactory sqlBuildFactory;
	@PostConstruct
	public void initDao() {
		super.setDataSource(dataSource);
	}
	@Override
	public Integer persistEntity(T t) {
		if(null == t) {
			throw new NullPointerException();
		}
		setBaseEntoty(t);
		SqlParam sqlParam = sqlBuildFactory.buildSql(clazz, PERSIST_ENTITY, t);
		LOGGER.debug("parmeter args: {}", Arrays.toString(sqlParam.getArgs()));
		return getJdbcTemplate().update(sqlParam.getSql(), sqlParam.getArgs());
	}
	@Override
	public Integer update(T t) {
		if(null == t) {
			throw new NullPointerException();
		}
		setBaseUpdateEntoty(t);
		SqlParam sqlParam = sqlBuildFactory.buildSql(clazz, UPDATE, t ,false);
		LOGGER.debug("parmeter args: {}", Arrays.toString(sqlParam.getArgs()));
		return getJdbcTemplate().update(sqlParam.getSql(), sqlParam.getArgs());
	}
	
	@Override
	public Integer updateNotnull(T t) {
		if(null == t) {
			throw new NullPointerException();
		}
		setBaseUpdateEntoty(t);
		SqlParam sqlParam = sqlBuildFactory.buildSql(clazz, UPDATE, t, true);
		LOGGER.debug("parmeter args: {}", Arrays.toString(sqlParam.getArgs()));
		return getJdbcTemplate().update(sqlParam.getSql(), sqlParam.getArgs());
	}

	@Override
	public Integer deleteByEntity(T t) {
		SqlParam sqlParam = sqlBuildFactory.buildSql(clazz, DELETE_BY_ENTITY, t, null);
		LOGGER.debug("parmeter args: {}", Arrays.toString(sqlParam.getArgs()));
		return getJdbcTemplate().update(sqlParam.getSql(), sqlParam.getArgs());
	}
	
	@Override
	public Integer deleteById(Long id) {
		SqlParam sqlParam = sqlBuildFactory.buildSql(clazz, DELETE_BY_ID, id);
		LOGGER.debug("parmeter args: {}", id);
		return getJdbcTemplate().update(sqlParam.getSql(), id);
	}
	
	public T findById(Long id) {
		try {
			if(null == id) {
				throw new HxJdbcRuntimeException("请选择一条记录");
			}
			SqlParam sqlParam = sqlBuildFactory.buildSql(clazz, FIND_BY_ID, id);
			RowMapper<T> rowMapper = rowMapperFactory.getRowMapper(clazz);
			LOGGER.debug("parmeter args: {}", sqlParam.getArgs());
			T t = getJdbcTemplate().queryForObject(sqlParam.getSql(), sqlParam.getArgs() , rowMapper);
			return t;
		} catch (EmptyResultDataAccessException e) {
			LOGGER.debug("result is empty");
		}
		return null;
	}

	@Override
	public List<T> findByIds(List<Long> ids) {
		if(null == ids || ids.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
		SqlParam sqlParam = sqlBuildFactory.buildSql(clazz, FIND_BY_IDS, ids);
		RowMapper<T> rowMapper = rowMapperFactory.getRowMapper(clazz);
		LOGGER.debug("parmeter args: {}", Arrays.toString(sqlParam.getArgs()));
		List<T> list = getJdbcTemplate().query(sqlParam.getSql(), sqlParam.getArgs(), rowMapper);
		return list;
	}

	@Override
	public List<T> findByEntity(T t) {
		return findByEntity(t, null);
	}
	
	@Override
	public List<T> findByEntity(T t, String orderBy) {
		SqlParam sqlParam = sqlBuildFactory.buildSql(clazz, FIND_BY_ENTITY, t, new Pageable(orderBy));
		RowMapper<T> rowMapper = rowMapperFactory.getRowMapper(clazz);
		LOGGER.debug("parmeter args: {}", Arrays.toString(sqlParam.getArgs()));
		List<T> list = getJdbcTemplate().query(sqlParam.getSql(),  sqlParam.getArgs(), rowMapper);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Page<T> findPage(T t, Pageable pageable){
		pageable = resetPageable(pageable);
		SqlParam sqlParam = sqlBuildFactory.buildSql(clazz, COUNT_BY_ENTITY, t, null);
		Long total = getJdbcTemplate().queryForObject(sqlParam.getSql(), sqlParam.getArgs(),Long.class);
		
		Page<T> pageResult = new Page<T>();
		pageResult.setTotal(total);
		pageResult.setPage(pageable.getPage());
		pageResult.setSize(pageable.getSize());
		
		if(total <= pageable.getOffset()) {
			pageResult.setData(Collections.EMPTY_LIST);
		} else {
			SqlParam dataSqlParam = sqlBuildFactory.buildSql(clazz, FIND_BY_ENTITY, t, pageable);
			LOGGER.debug("parmeter args: {}", Arrays.toString(dataSqlParam.getArgs()));
			RowMapper<T> rowMapper = rowMapperFactory.getRowMapper(clazz);
			List<T> list = getJdbcTemplate().query(dataSqlParam.getSql(),  dataSqlParam.getArgs(), rowMapper);
			pageResult.setData(list);
		}
		return pageResult;
	}

    @Override
    public List<T> findAll() {
		LOGGER.debug(">>> findAll <<<");
		SqlParam dataSqlParam = sqlBuildFactory.buildSql(clazz, FIND_ALL);
		RowMapper<T> rowMapper = rowMapperFactory.getRowMapper(clazz);
        return getJdbcTemplate().query(dataSqlParam.getSql(), rowMapper);
    }

    public<Entity> RowMapper<Entity> getRowMapper(Class<Entity> clazz){
		return rowMapperFactory.getRowMapper(clazz);
	}

	public RowMapper<T> getRowMapper(){
		return rowMapperFactory.getRowMapper(clazz);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void initTemplateConfig() {
		// 获取泛型
		Type type = getParameterizedType(getClass());
		if(null != type) {
			Type[] typeArr = ((ParameterizedType) type).getActualTypeArguments();
			clazz = (Class<T>) typeArr[0];
		} else {
			throw new HxJdbcRuntimeException("类型解析异常");
		}
	}
	/**
	 * @param pageable
	 * @return
	 */
	private Pageable resetPageable(Pageable pageable) {
		if(null == pageable) {
			pageable = new Pageable();
		}
		if(null == pageable.getPage()) {
			pageable.setPage(1);
		}
		if(null == pageable.getSize()) {
			pageable.setSize(10);
		}
		return pageable;
	}
	/**
	 * @param t
	 */
	private void setBaseEntoty(T t) {
		if(!(t instanceof AutoLongBaseEntity)) {
			return;
		}
		AutoLongBaseEntity baseEntity = (AutoLongBaseEntity) t;
		Date createdDate = baseEntity.getCreatedDate();
		if(null == createdDate) {
			createdDate = new Date();
		}
		baseEntity.setCreatedDate(createdDate);
		if(null == baseEntity.getLastModifiedDate()) {
			baseEntity.setLastModifiedDate(createdDate);
		}
		if(null == baseEntity.getLastModifiedBy()) {
			baseEntity.setLastModifiedBy(baseEntity.getCreatedBy());
		}
	}
	/**
	 * @param t
	 */
	private void setBaseUpdateEntoty(T t) {
		if(!(t instanceof AutoLongBaseEntity)) {
			return;
		}
		AutoLongBaseEntity baseEntity = (AutoLongBaseEntity) t;
		if(null == baseEntity.getLastModifiedDate()) {
			baseEntity.setLastModifiedDate(new Date());
		}
	}
	/**
	 * @param type
	 * @return
	 */
	private Type getParameterizedType(Type type){
        if(type instanceof Class) {
            return getParameterizedType(((Class<?>) type).getGenericSuperclass());
        } else if (type instanceof ParameterizedType){
            String typeName = type.getTypeName();
            if(typeName.startsWith("org.layz.hx.spring.jdbc.repository.BaseDaoImpl<")){
                return type;
            }
            return getParameterizedType(((ParameterizedType) type).getRawType());
        }
        return null;
    }
}
