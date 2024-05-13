package com.ohgiraffers.common;

public class TeamMemberDTO {
    private int id;
    private String name;
    private String email;
    private String phone;
    private int taskCode;

    public TeamMemberDTO() {
    }

    public TeamMemberDTO(int id, String name, String email, String phone, int taskCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.taskCode = taskCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(int taskCode) {
        this.taskCode = taskCode;
    }

    @Override
    public String toString() {
        return "TeamMemberDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", taskCode=" + taskCode +
                '}';
    }
}

