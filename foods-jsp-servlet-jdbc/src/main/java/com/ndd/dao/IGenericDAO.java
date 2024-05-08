package com.ndd.dao;

import java.util.List;

import com.ndd.mapper.RowMapper;

public interface IGenericDAO<T> {
	List<T> query(String sql, RowMapper<T> rowMapper, Object... params);
	
	
}
