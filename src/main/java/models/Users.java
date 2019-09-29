package models;

import java.util.Objects;

public class Users {
    private String position;
    private String role;
    private int department_id;
    private  int id;

    public Users(String position, String role, int department_id) {
        this.position = position;
        this.role = role;
        this.department_id = department_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return department_id == users.department_id &&
                id == users.id &&
                Objects.equals(position, users.position) &&
                Objects.equals(role, users.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, role, department_id, id);
    }
}