package com.ndd.dao;

import java.util.List;

import com.ndd.mapper.RowMapper;

public interface IGenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	
	void update(String sql, Object... parameters);
	
	Long insert(String sql, Object... parameters);
}
