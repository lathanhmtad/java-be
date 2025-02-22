package com.ndd.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.ndd.model.NewsModel;

public class NewsMapper implements RowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet rs) {
		try {
			NewsModel news = new NewsModel();
			news.setId(rs.getLong("id"));
			news.setTitle(rs.getString("title"));
			
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
