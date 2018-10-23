package com.cdivtc.datatransfertest;

import java.io.Serializable;

/**
 * Created by 28461 on 2018/10/12.
 * 商品信息类
 */

public class ItemInfo implements Serializable{
    private String name;
    private int life;
    private int attack;
    private int speed;

    //全参的构造方法

    public ItemInfo(String name, int life, int attack, int speed) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.speed = speed;
    }

    //创建getter 和setter方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
