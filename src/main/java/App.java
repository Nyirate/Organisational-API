import static spark.Spark.*;
import com.google.gson.Gson;
import exceptions.ApiException;
import models.Department;
import models.Users;
import models.News;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.Route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Connection conn;
        Gson gson = new Gson();

        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/organisation";
        Sql2o sql2o = new Sql2o(connectionString, "emmy", "123456");

        //get: new department form
        get("/new", (Route) (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "department-form.hbs");
        }, new HandlebarsTemplateEngine());

    }
}