package egovframework.example.sample.service.entities;

import org.springframework.stereotype.Component;

@Component("boardVO") 
public class BoardVO {
	
	private long id;
	private String job;
	private String title;
	private String contents;
	
	
	public BoardVO() {}
	
	public BoardVO(String job, String title, String contents, long id) {
		this.id = id; 
		this.job = job;
		this.title = title;
		this.contents = contents;
	}
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return this.title + " " + this.contents;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
