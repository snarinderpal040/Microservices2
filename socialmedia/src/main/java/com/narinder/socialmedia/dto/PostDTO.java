package com.narinder.socialmedia.dto;

public class PostDTO {

	private Integer postId;
	
	private String postMessage;

	public PostDTO() {
		
	}
	
	public PostDTO(Integer postId, String postMessage) {
		super();
		this.postId = postId;
		this.postMessage = postMessage;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostMessage() {
		return postMessage;
	}

	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postMessage=" + postMessage + "]";
	}
	
}
