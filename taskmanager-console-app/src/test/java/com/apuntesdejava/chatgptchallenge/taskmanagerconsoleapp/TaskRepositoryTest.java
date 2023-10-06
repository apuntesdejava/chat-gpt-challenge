package com.apuntesdejava.chatgptchallenge.taskmanagerconsoleapp;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author diego
 */
public class TaskRepositoryTest {

  public TaskRepositoryTest() {
  }
  private static final File taskListFile = new File("task_list_test.list");
  static TaskRepository taskRepository = new TaskRepository(taskListFile);

  @Test
  public void testLoad() {
    try {
      taskRepository.loadTaskList();
      taskRepository.getTaskList().forEach(task -> System.out.println("-->"+task.getDescription()));
    } catch (IOException ex) {
      fail(ex);
    }
  }

  @Test
  public void testSave() {
    try {
      taskRepository.saveTaskList();
    } catch (IOException ex) {
      fail(ex);
    }
  }

  /**
   * Test of addTask method, of class TaskRepository.
   */
  @org.junit.jupiter.api.Test
  public void testAddTask() {
    System.out.println("addTask");
    taskRepository.addTask("Tarea 1");
    taskRepository.addTask("Tarea 2");
    taskRepository.addTask("Tarea 3");

  }

  /**
   * Test of getTaskList method, of class TaskRepository.
   */
  @org.junit.jupiter.api.Test
  public void testGetTaskList() {
    System.out.println("getTaskList");
    assertEquals(3, taskRepository.getTaskList().size());
  }

  /**
   * Test of setTaskCompleted method, of class TaskRepository.
   */
  @org.junit.jupiter.api.Test
  public void testSetTaskCompleted() {
    System.out.println("setTaskCompleted");
    taskRepository.setTaskCompleted(2);
    var taskList = taskRepository.getTaskList();
    var notCompleted = taskList.stream().filter(task -> !task.isCompleted()).count();
    assertEquals(2, notCompleted);
  }

  /**
   * Test of deleteTask method, of class TaskRepository.
   */
  @org.junit.jupiter.api.Test
  public void testDeleteTask() {
    System.out.println("deleteTask");
    taskRepository.deleteTask(1);
    assertEquals(2, taskRepository.getTaskList().size());
  }

}
