package models;

import java.util.ArrayList;
import java.util.Objects;

public class Users {
    private String positions;
    private String role;
    private int department_id;
    private  int user_id;

    public Users(int department_id, String positions, String role) {
        this.department_id = department_id;
        this.positions = positions;
        this.role = role;

    }

    public static ArrayList<Users> getAll() {
        return  null;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getPositions() {
        return positions;
    }

    public void setPosition(String position) {
        this.positions = positions;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUser_idId() {
        return user_id;
    }

    public void setUser_id(int id) {
        this.user_id = user_id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Users)) return false;
//        Users users = (Users) o;
//        return department_id == users.department_id &&
//                user_id == users.user_id &&
//                Objects.equals(positions, users.positions) &&
//                Objects.equals(role, users.role);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(department_id, positions, role, user_id);
//    }


}