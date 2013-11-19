package se.kth.common.model.bo;

// Generated Nov 13, 2013 3:03:35 PM by Hibernate Tools 4.0.0

import java.util.Date;

import com.google.gson.annotations.Expose;

/**
 * PrivateMessage generated by hbm2java
 */
public class PrivateMessage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Expose
	private int privateMessageId;
	@Expose
	private User toUser;
	@Expose
	private User fromUser;
	@Expose
	private String message;
	private Date messageSent;

	public PrivateMessage() {
	}

	public PrivateMessage(int privateMessageId, User userByToUser,
			User userByFromUser, Date messageSent) {
		this.privateMessageId = privateMessageId;
		this.messageSent = messageSent;
	}

	public PrivateMessage(int privateMessageId, User userByToUser,
			User userByFromUser, String message, Date messageSent) {
		this.privateMessageId = privateMessageId;
		this.message = message;
		this.messageSent = messageSent;
	}

	public int getPrivateMessageId() {
		return this.privateMessageId;
	}

	public void setPrivateMessageId(int privateMessageId) {
		this.privateMessageId = privateMessageId;
	}

	public User getToUser() {
		return this.toUser;
	}

	public void setToUser(User userByToUser) {
		this.toUser = userByToUser;
	}

	public User getFromUser() {
		return this.fromUser;
	}

	public void setFromUser(User userByFromUser) {
		this.fromUser = userByFromUser;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getMessageSent() {
		return this.messageSent;
	}

	public void setMessageSent(Date messageSent) {
		this.messageSent = messageSent;
	}

}
