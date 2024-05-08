package com.ndd.dao;

import java.util.List;

import com.ndd.mapper.RowMapper;

public interface IGenericDAO<T> {
	List<T> query(String sql, RowMapper<T> rowMapper, Object... params);
	
	boolean update(String sql, Object... params);
	
	boolean delete(String sql, Object... params);
}
