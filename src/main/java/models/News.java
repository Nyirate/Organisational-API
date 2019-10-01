package models;

import java.util.Objects;

public class News {
    private String general_news;
    private String department_news;

    public News(String general_news, String department_news) {
        this.general_news = general_news;
        this.department_news = department_news;
    }

    public String getGeneral_news() {
        return general_news;
    }

    public void setGeneral_news(String general_news) {
        this.general_news = general_news;
    }

    public String getDepartment_news() {
        return department_news;
    }

    public void setDepartment_news(String department_news) {
        this.department_news = department_news;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof News)) return false;
//        News news = (News) o;
//        return Objects.equals(general_news, news.general_news) &&
//                Objects.equals(department_news, news.department_news);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(general_news, department_news);
//    }
}
