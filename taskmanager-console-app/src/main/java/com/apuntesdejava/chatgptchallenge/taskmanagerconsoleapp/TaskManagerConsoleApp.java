package com.apuntesdejava.chatgptchallenge.taskmanagerconsoleapp;

import static com.apuntesdejava.chatgptchallenge.taskmanagerconsoleapp.Constants.EXIT;
import static com.apuntesdejava.chatgptchallenge.taskmanagerconsoleapp.Constants.TASK_ADD;
import static com.apuntesdejava.chatgptchallenge.taskmanagerconsoleapp.Constants.TASK_COMPLETED;
import static com.apuntesdejava.chatgptchallenge.taskmanagerconsoleapp.Constants.TASK_DELETED;
import static com.apuntesdejava.chatgptchallenge.taskmanagerconsoleapp.Constants.TASK_LIST;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskManagerConsoleApp {

  public static void main(String[] args) {
    try {
      new TaskManagerConsoleApp().start();
    } catch (IOException ex) {
      Logger.getLogger(TaskManagerConsoleApp.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private final List<String> VALID_OTIONS = List.of(
    TASK_ADD,
    TASK_LIST,
    TASK_COMPLETED,
    TASK_DELETED,
    EXIT
  );
  private final File taskListFile = new File("task_list.list");
  private final TaskRepository taskRepository = new TaskRepository(taskListFile);

  private void start() throws IOException {
    String option;
    taskRepository.loadTaskList();
    do {
      showMenu();
      option = readOption();
      switch (option) {
        case TASK_ADD ->
          addTask();
        case TASK_LIST ->
          listTask();
        case TASK_COMPLETED ->
          completeTask();
        case TASK_DELETED ->
          deleteTask();
      }

    } while (!option.equals(EXIT));
    taskRepository.saveTaskList();
  }

  private String readOption() {

    String option;
    do {
      option = System.console().readLine("Seleccione una opción:");
    } while (!VALID_OTIONS.contains(option));

    return option;

  }

  private void showMenu() {
    System.out.println("---------------");
    System.out.println("Lista de Tareas");
    System.out.println("1. Agregar tarea");
    System.out.println("2. Ver lista de tareas");
    System.out.println("3. Marcar tarea como completada");
    System.out.println("4. Eliminar tarea");
    System.out.println("5. Salir");

  }

  private void addTask() {
    System.out.println("---------------");
    System.out.println("AGREGAR TAREA");
    var description = System.console().readLine("Escriba la tarea:");
    taskRepository.addTask(description);
  }

  private void listTask() {
    System.out.println("---------------");
    System.out.println("LISTADO DE TAREAS");
    var taskList = taskRepository.getTaskList();
    taskList.forEach(task -> {
      System.out.printf("%03d %-50s %s%n", task.getId(), task.getDescription(), task.isCompleted());
    });
    System.out.println();
  }

  private void completeTask() {
    System.out.println("---------------");
    System.out.println("MARCAR TAREA A COMPLETAR");
    var taskIdString = System.console().readLine("Indique el Id de la tarea:");
    var taskId = Integer.parseInt(taskIdString);
    taskRepository.setTaskCompleted(taskId);
  }

  private void deleteTask() {
    System.out.println("---------------");
    System.out.println("ELIMINAR TAREA");
    var taskIdString = System.console().readLine("Indique el Id de la tarea:");
    var taskId = Integer.parseInt(taskIdString);
    taskRepository.deleteTask(taskId);
  }
}
