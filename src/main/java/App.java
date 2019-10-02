import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Department;
import models.News;
import models.Users;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static  void main(String[] args) { //type “psvm + tab” to autocreate this
        staticFileLocation("/public");

        //get: home
        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"home.hbs");
        },new HandlebarsTemplateEngine());


        //get: new department form
        get("/one",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"department-form.hbs");
        },new HandlebarsTemplateEngine());

        //post: process new department form
        post ("/two",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String name =request.queryParams("name");
            int employees = Integer.parseInt(request.queryParams("employees"));
            String description = request.queryParams("description");
            Department newIdentity =new Department(name,employees,description);
            model.put("name",newIdentity.getName());
            model.put("department",newIdentity);
            return new ModelAndView(model,"pass1.hbs");
        }, new HandlebarsTemplateEngine());

        get("/three",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            ArrayList<Department> departs=Department.all();
            model.put("departs",departs);
            return new ModelAndView(model,"department.hbs");
        },new HandlebarsTemplateEngine());


        //get: show user form
        get("/four",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"user-form.hbs");
        },new HandlebarsTemplateEngine());


        //post: process user form
        post ("/five",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            int department_id = Integer.parseInt(request.queryParams("department_id"));
            String positions =request.queryParams("positions");
            String role = request.queryParams("role");
            Users newUsersIdentity =new Users(department_id,positions,role);
            model.put("department_id",newUsersIdentity.getDepartment_id());
            model.put("positions",newUsersIdentity.getPositions());
            model.put("role",newUsersIdentity.getRole());
            return new ModelAndView(model,"pass2.hbs");
        }, new HandlebarsTemplateEngine());


        get("/six",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Users> user=Users.getAll();
            System.out.println(user);
            model.put("user", user);
            return new ModelAndView(model,"user.hbs");
        },new HandlebarsTemplateEngine());

        //get: news form
    get("/seven",(request, response) -> {
        Map<String,Object> model = new HashMap<>();
        return new ModelAndView(model,"news-form.hbs");
    },new HandlebarsTemplateEngine());


    //post: process news form
    post ("/eight",(request, response) -> {
        Map<String,Object>model = new HashMap<>();
        String heading =request.queryParams("heading");
        String news = request.queryParams("news");
        String content = request.queryParams("content");
        News newNewsIdentity =new News(heading, news, content);
        model.put("heading",newNewsIdentity.getHeading());
        model.put("news",newNewsIdentity.getNews());
        model.put("content",newNewsIdentity.getContent());
        return new ModelAndView(model,"pass3.hbs");
    }, new HandlebarsTemplateEngine());


    get("/nine",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        ArrayList<News> news= News.getAll();
        System.out.println(news);
        model.put("news", news);
        return new ModelAndView(model,"news.hbs");
    },new HandlebarsTemplateEngine());

    }


}
