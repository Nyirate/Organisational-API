package models;

import java.util.ArrayList;
import java.util.Objects;

public class News {
    private String heading;
    private String news;
    private String content;


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

}
