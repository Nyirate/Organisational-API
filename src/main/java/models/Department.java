package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static models.DB.sql2o;

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

    public void save() {
        try(org.sql2o.Connection con = sql2o.open()) {
            String sql = "INSERT INTO department (name, employees, description) VALUES (:name, :employees, :description)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("employees", this.employees)
                    .addParameter("description", this.description)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Department> all() {

        String s="select * from department;";
        try(Connection con = sql2o.open()){
            return con.createQuery(s).executeAndFetch(Department.class);
        }
    }
    public void deleteById(int id) {
    }

}