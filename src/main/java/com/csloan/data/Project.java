package com.csloan.data;

public class Project {

	private String id;
	private String name;
	private String description;
	private String smallIconLink;
	private String largeIconLink;
	private String repoLink;
	private String techUsed;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSmallIconLink() {
		return smallIconLink;
	}
	public void setSmallIconLink(String smallIconLink) {
		this.smallIconLink = smallIconLink;
	}
	public String getLargeIconLink() {
		return largeIconLink;
	}
	public void setLargeIconLink(String largeIconLink) {
		this.largeIconLink = largeIconLink;
	}
	public String getRepoLink() {
		return repoLink;
	}
	public void setRepoLink(String repoLink) {
		this.repoLink = repoLink;
	}
	public String getTechUsed() {
		return techUsed;
	}
	public void setTechUsed(String techUsed) {
		this.techUsed = techUsed;
	}
	
}
