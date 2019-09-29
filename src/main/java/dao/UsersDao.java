package dao;
import models.Users;
import models.Department;

import java.util.List;

public interface UsersDao {



    //create
    void add(Users users);
    void addUsersToDepartment(Users users, Department department);

    //read
    List<Users> getAll();
    List<Department> getAllDepartmentsForAUser(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();

    Users findById(int id);
}