package dao;
import models.News;
import models.Department;

import java.util.List;

public interface NewsDao {



    //create
    void add(News news);
    void addNewsToADepartment(News news, Department department);

    //read
    List<News> getAll();
    List<News> getAllNewsByADepartment(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();

}

