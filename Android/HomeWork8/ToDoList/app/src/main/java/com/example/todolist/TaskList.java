package com.example.todolist;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskList {
    private static final TaskList instance = new TaskList();
    private List<Task> mAllTasks = new ArrayList();

    public static TaskList getInstance() {
        return instance;
    }

    public List<Task> getTasks() {
        return this.mAllTasks;
    }

    private TaskList() {
    }

    public void addTask(Task task) {
        this.mAllTasks.add(task);
    }

    public void removeTask(Task task) {
        int index = findTask(task, this.mAllTasks);
        if (index > -1) {
            this.mAllTasks.remove(index);
        }
    }

    public Task getTask(UUID taskId) {
        for (Task task : this.mAllTasks) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }

    private static int findTask(Task task, List<Task> list) {
        for (int i = 0; i < list.size(); i++) {
            if (((Task) list.get(i)).getId().equals(task.getId())) {
                return i;
            }
        }
        return -1;
    }


}