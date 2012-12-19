package org.springframework.webflow.samples.booking;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A user who can book hotels.
 */
@Entity
@Table(name = "Customer")
public class User implements Serializable {
    private String username;

    private String password;

    private String name;

    public User() {
    }

    public User(String username, String password, String name) {
	this.username = username;
	this.password = password;
	this.name = name;
    }

    @Id
    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "User(" + username + ")";
    }
}
