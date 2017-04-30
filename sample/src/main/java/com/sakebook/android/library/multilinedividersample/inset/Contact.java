package com.sakebook.android.library.multilinedividersample.inset;

/**
 * Created by sakemotoshinya on 2017/04/30.
 */

public class Contact {
    private String name;
    private boolean favorite;

    public Contact(String name, boolean favorite) {
        this.name = name;
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public boolean isFavorite() {
        return favorite;
    }
}
