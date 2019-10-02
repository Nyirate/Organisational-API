package models;

import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

import static models.DB.sql2o;

public class News {
    private String heading;
    private String news;
    private String content;
    private int id;


    public News(String heading, String news, String content) {
        this.heading = heading;
        this.news = news;
        this.content = content;
    }

    public static ArrayList<News> getAll() {
        return null;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void save() {
        try(org.sql2o.Connection con = sql2o.open()) {
            String sql = "INSERT INTO news(heading, news, content) VALUES (:heading, :news, :content)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("heading", this.heading)
                    .addParameter("news", this.news)
                    .addParameter("content", this.content)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<News> all() {

        String s="select * from news;";
        try(Connection con = sql2o.open()){
            return con.createQuery(s).executeAndFetch(News.class);
        }
    }
    public void deleteById(int id) {
    }

}
