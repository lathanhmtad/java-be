package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.NewsModel;

public class NewsMapper implements RowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet rs) {
		NewsModel news = null;
		try {
			news = new NewsModel();
			news.setId(rs.getLong("id"));
			news.setTitle(rs.getString("title"));
			news.setShortDescription(rs.getString("shortdescription"));
			news.setContent(rs.getString("content"));
			news.setCategoryId(rs.getLong("categoryid"));
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
