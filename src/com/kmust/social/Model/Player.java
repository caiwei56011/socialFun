package com.kmust.social.Model;

import java.io.Serializable;

/**
 * Player
 *
 * @author Cai Wei
 * @date 2017/1/14
 */
public class Player implements Serializable{
    private static final long serialVersionUID = 7496701174321802283L;
    private int id;
    private String name;
    private String age;
    private String score;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
