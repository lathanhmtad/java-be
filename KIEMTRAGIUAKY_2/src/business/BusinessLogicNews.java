package business;

import java.util.ArrayList;

import data.ProcessData;
import entities.Category;
import entities.News;
import presentation.NewsView;

public class BusinessLogicNews {
	NewsView newsView;

	public BusinessLogicNews(NewsView newsView) {
		this.newsView = newsView;
	}

	public int insert() {
		String title = newsView.textFieldTitle.getText();
		Category category = (Category) newsView.comboBoxCategory.getSelectedItem();
		String content = newsView.textAreaContent.getText();

		// set object news from view
		News news = new News();
		news.setTitle(title);
		news.setContent(content);
		news.setCategory(category);

		// insert data into database
		int result = ProcessData.insertNews(news);

		return result;
	}

	public int remove() {
		int id;
		try {
			id = Integer.parseInt(newsView.textFieldIdNews.getText());
		} catch (NumberFormatException e) {
			return 0;
		}
		

		return ProcessData.deleteNews(id);
	}

	public int edit() {
		int idNews = Integer.parseInt(newsView.textFieldIdNews.getText());
		String title = newsView.textFieldTitle.getText();
		Category category = (Category) newsView.comboBoxCategory.getSelectedItem();
		String content = newsView.textAreaContent.getText();

		News news = new News();
		news.setId(idNews);
		news.setTitle(title);
		news.setCategory(category);
		news.setContent(content);

		return ProcessData.updateNews(news); 
	}

	public News search() {
		int newsId;
		
		try {
			newsId = Integer.parseInt(newsView.textFieldIdNews.getText());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
		
		News result = ProcessData.searchNews(newsId);
		return result;
	}
	
	public void setFormValue(News news) {
		newsView.textFieldIdNews.setText(String.valueOf(news.getId()));
		newsView.comboBoxCategory.setSelectedIndex(news.getCategory().getId() - 1);
		newsView.textFieldTitle.setText(news.getTitle());
		newsView.textAreaContent.setText(news.getContent());
	}

	
	public void refreshTable() {
		int rows = newsView.tableModel.getRowCount();
		for (int i = rows - 1; i >= 0; i--) {
			newsView.tableModel.removeRow(i);
		}

		ArrayList<News> listNews = ProcessData.getListNews();
		for (News news : listNews) {
			Object[] newRow = { news.getId(), news.getTitle() };
			newsView.tableModel.addRow(newRow);
		}
	}

}
