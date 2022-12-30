package egovframework.example.sample.service;

import org.springframework.stereotype.Component;

@Component
public class BoardVO {
	
	private String job;
	private String title;
	private String contents;
	
	
	public BoardVO() {}
	
	public BoardVO(String job, String title, String contents) {
		super();
		this.job = job;
		this.title = title;
		this.contents = contents;
	}
	
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	
	

}
