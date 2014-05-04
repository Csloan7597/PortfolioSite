package com.csloan.data;

public class Project {

	private String id;
	private String name;
	private String shortDescription;
	private String smallIconLink;
	private String largeIconLink;
	private String repoLink;
	private String techUsed;
	private String longDescription;
	
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
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String description) {
		this.longDescription = description;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String description) {
		this.shortDescription = description;
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
