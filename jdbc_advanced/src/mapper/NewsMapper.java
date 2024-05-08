package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.News;

public class NewsMapper implements RowMapper<News> {

	@Override
	public News mapRow(ResultSet resultSet) {
		News news = new News();
		try {
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
