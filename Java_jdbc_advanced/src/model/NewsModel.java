package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class NewsModel extends AbstractModel<NewsModel>{
	private String title;
	private String thumbnail;
	private String shortDescription;
	private String content;
	private Long categoryId;
}
