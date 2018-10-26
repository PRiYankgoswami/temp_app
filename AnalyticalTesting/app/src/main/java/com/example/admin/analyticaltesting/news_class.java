package com.example.admin.analyticaltesting;

public class news_class
{
    String news_title,news_body,p_date,day;
    boolean read_news=false;

    public news_class(String news_title, String news_body, String p_date, String day)
    {
        this.news_title = news_title;
        this.news_body = news_body;
        this.p_date = p_date;
        this.day = day;
    }
}
