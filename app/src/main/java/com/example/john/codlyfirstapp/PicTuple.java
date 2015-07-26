package com.example.john.codlyfirstapp;

/**
 * Created by john on 2/6/2015.
 */
public class PicTuple {
    private String pic;
    private int time;

    public PicTuple(String pic, int time) {
        this.pic = pic;
        this.time = time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public int getTime() {
        return time;
    }

}
