package com.ohgiraffers.common;

public class TaskDTO {

    private int taskCode;
    private String taskName;
    private int deadline;
    private String completed;

    public TaskDTO() {
    }

    public TaskDTO(int taskCode, String taskName, int deadline, String completed) {
        this.taskCode = taskCode;
        this.taskName = taskName;
        this.deadline = deadline;
        this.completed = completed;
    }

    public int getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(int taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "taskCode=" + taskCode +
                ", taskName='" + taskName + '\'' +
                ", deadline=" + deadline +
                ", completed='" + completed + '\'' +
                '}';
    }
}

