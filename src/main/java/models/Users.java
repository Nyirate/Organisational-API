package models;

import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

import static models.DB.sql2o;

public class Users {
    private String positions;
    private String role;
    private int department_id;
    private  int id;

    public Users(String positions, int department_id, String role) {
        this.positions = positions;
        this.department_id = department_id;
        this.role = role;

    }


    public static ArrayList<Users> getAll() {
        return  null;
    }

    public String getPositions() {
        return positions;
    }

    public void setPosition(String position) {
        this.positions = positions;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void save() {
        try(org.sql2o.Connection con = sql2o.open()) {
            String sql = "INSERT INTO users (positions, department_id, role) VALUES (:positions, :department_id, :role)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("positions", this.positions)
                    .addParameter("department_id", this.department_id)
                    .addParameter("role", this.role)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Users> all() {

        String s="select * from users;";
        try(Connection con = sql2o.open()){
            return con.createQuery(s).executeAndFetch(Users.class);
        }
    }
    public void deleteById(int id) {
    }

}