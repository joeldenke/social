package se.kth.model.bo;

// Generated Nov 13, 2013 2:23:29 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String username;
	private String password;
	private UserProfile userProfile;
	private Set<UserLogMessage> userLogMessages = new HashSet<UserLogMessage>(0);
	private Set<PrivateMessage> privateMessagesForFromUser = new HashSet<PrivateMessage>(
			0);
	private Set<PrivateMessage> privateMessagesForToUser = new HashSet<PrivateMessage>(
			0);

	public User() {
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, UserProfile userProfile,
			Set<UserLogMessage> userLogMessages,
			Set<PrivateMessage> privateMessagesForFromUser,
			Set<PrivateMessage> privateMessagesForToUser) {
		this.username = username;
		this.password = password;
		this.userProfile = userProfile;
		this.userLogMessages = userLogMessages;
		this.privateMessagesForFromUser = privateMessagesForFromUser;
		this.privateMessagesForToUser = privateMessagesForToUser;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Set<UserLogMessage> getUserLogMessages() {
		return this.userLogMessages;
	}

	public void setUserLogMessages(Set<UserLogMessage> userLogMessages) {
		this.userLogMessages = userLogMessages;
	}

	public Set<PrivateMessage> getPrivateMessagesForFromUser() {
		return this.privateMessagesForFromUser;
	}

	public void setPrivateMessagesForFromUser(
			Set<PrivateMessage> privateMessagesForFromUser) {
		this.privateMessagesForFromUser = privateMessagesForFromUser;
	}

	public Set<PrivateMessage> getPrivateMessagesForToUser() {
		return this.privateMessagesForToUser;
	}

	public void setPrivateMessagesForToUser(
			Set<PrivateMessage> privateMessagesForToUser) {
		this.privateMessagesForToUser = privateMessagesForToUser;
	}

}
