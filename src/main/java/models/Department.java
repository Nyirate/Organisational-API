package models;

import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {
    private String name;
    private int employees;
    private String description;
    private int id;

    public Department(String name, int employees, String description) {
        this.name = name;
        this.employees = employees;
        this.description = description;
    }

    public static ArrayList<Department> all() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Department)) return false;
//        Department that = (Department) o;
//        return id == that.id &&
//                employees == that.employees &&
//                Objects.equals(name, that.name) &&
//                Objects.equals(description, that.description);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, id, employees, description);
//    }

}