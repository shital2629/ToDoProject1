package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String taskName;
	boolean status;
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(int id, String taskName, boolean status) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", status=" + status + "]";
	}
}
