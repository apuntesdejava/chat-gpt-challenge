package com.apuntesdejava.chatgptchallenge.taskmanagerconsoleapp;

import java.io.Serializable;

public class Task implements Serializable{

  private int id;
  private String description;
  private boolean completed;

  public Task() {
  }

  public Task(int id, String description) {
    this.id = id;
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 67 * hash + this.id;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Task other = (Task) obj;
    return this.id == other.id;
  }

}
