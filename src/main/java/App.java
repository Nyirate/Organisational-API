import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        get("/dep",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"department-form.hbs");
        },new HandlebarsTemplateEngine());

        //post: process new hero form
        post ("/news",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String name =request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power= request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newIdentity =new Hero(name,age,power,weakness);
            model.put("name",newIdentity.getName());
            model.put("hero",newIdentity);
            return new ModelAndView(model,"pass.hbs");
        }, new HandlebarsTemplateEngine());

/*
        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            ArrayList<Post> posts=Post.getAll();
            model.put("Posts",posts);
            return new ModelAndView(model,"heroes.hbs");
        },new HandlebarsTemplateEngine());*/

        get("/nell",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            ArrayList<Hero> posts=Hero.all();
            model.put("posts",posts);
            return new ModelAndView(model,"heroes.hbs");
        },new HandlebarsTemplateEngine());


        //get: show squad form
        get("/squad",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"squad-form.hbs");
        },new HandlebarsTemplateEngine());


        //post: process a squad form
        post ("/yes",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String name =request.queryParams("name");
            String cause = request.queryParams("cause");
            int size = Integer.parseInt(request.queryParams("size"));
            Squad newSquadIdentity =new Squad(name,cause,size);
            model.put("name",newSquadIdentity.getName());
            model.put("cause",newSquadIdentity.getCause());
            model.put("size",newSquadIdentity.getSize());
            model.put("squads1",newSquadIdentity );
            return new ModelAndView(model,"pass2.hbs");
        }, new HandlebarsTemplateEngine());


        get("/yes",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads=Squad.getAll();
            System.out.println(squads);
            model.put("squads", squads);
            return new ModelAndView(model,"squad-list.hbs");
        },new HandlebarsTemplateEngine());

    }
}