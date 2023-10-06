package com.apuntesdejava.chatgptchallenge.taskmanagerconsoleapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskRepository {

    private final List<Task> taskList = new ArrayList<>();

    private final File taskListFile;

    public TaskRepository(File taskListFile) {
        this.taskListFile = taskListFile;
    }

    public void addTask(String description) {
        var nextId = taskList.stream()
            .max(Comparator.comparing(Task::getId))
            .map(Task::getId)
            .orElse(0) + 1;
        var task = new Task(nextId, description);
        taskList.add(task);
    }

    public List<Task> getTaskList() {
        return List.copyOf(taskList);
    }

    public void setTaskCompleted(int taskId) {
        for (var task : taskList) {
            if (task.getId() == taskId) {
                task.setCompleted(true);
                break;
            }
        }
    }

    public void deleteTask(int taskId) {
        taskList.removeIf(task -> task.getId() == taskId);
    }

    public void loadTaskList() throws FileNotFoundException, IOException {
        if (taskListFile.exists()) {
            try (var fis = new FileInputStream(taskListFile); var ois = new ObjectInputStream(
                fis)) {
                var taskListReaded = (List<Task>) ois.readObject();
                taskList.addAll(taskListReaded);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaskRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void saveTaskList() throws FileNotFoundException, IOException {
        try (var fos = new FileOutputStream(taskListFile); var oos = new ObjectOutputStream(fos)) {
            oos.writeObject(taskList);
            oos.flush();
        }
    }

}
