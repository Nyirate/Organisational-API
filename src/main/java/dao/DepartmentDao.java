package dao;
import models.Department;
import models.Users;

import java.util.List;

public interface DepartmentDao {



    //create
    void add(Department department);
    void addDepartmentToUsers(Department department, Users users);

    //read
    List<Department> getAll();
    List<Users> getAllUsersInADepartment(int department_id);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();

    Department findById(int id);
}
