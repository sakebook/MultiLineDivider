package com.sakebook.android.library.multilinedividersample.dash;

/**
 * Created by sakemotoshinya on 2017/05/02.
 */

public class Ticket {
    private String title;
    private String description;
    private int price;

    public Ticket(String title, String description, int price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
