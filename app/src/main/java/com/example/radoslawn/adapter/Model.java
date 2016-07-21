package com.example.radoslawn.adapter;

/**
 * Created by radoslawn on 18.07.16.
 */
public class Model {
    Integer img_id = null;
    String title= null;
    String discribe = null;
    Character firstLetter = null;

    public Model(int img, String s1, String s2) {
        this.img_id = img;
        this.title = s1;
        this.discribe = s2;
    }

    public Model(Character firstLetter) {
        this.firstLetter = firstLetter;
    }

    public int getImg_id() {
        return img_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDiscribe() {
        return discribe;
    }

    public Character getFirstLetter() {
        return firstLetter;
    }
    /*Przypomnieć metode builder dla konstruktora i compareTo dla sortowania*/

    @Override
    public String toString() {
        return super.toString();
    }
}

