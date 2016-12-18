package org.babypro.domain;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * Bambix : 辅食类
 * Created by apple on 2016/11/15.
 */
@Entity
@Table(name = "bambix")
public class Bambix {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="bambix_id")
    private int bambixId;

    @Column(name="bambix_currentTime")
    private Date bambixCurrentTime;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, optional = true)
    @JoinColumn(name="food_id")
    private Food food;

    @Column(name="bambix_weight")
    private String bambixWeight;


    @Column(name="user_openid")
    private String userOpenId;


    public int getBambixId() {
        return bambixId;
    }

    public void setBambixId(int pBambixId) {
        bambixId = pBambixId;
    }

    public Date getBambixCurrentTime() {
        return bambixCurrentTime;
    }

    public void setBambixCurrentTime(Date pBambixCurrentTime) {
        bambixCurrentTime = pBambixCurrentTime;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food pFood) {
        food = pFood;
    }

    public String getBambixWeight() {
        return bambixWeight;
    }

    public void setBambixWeight(String pBambixWeight) {
        bambixWeight = pBambixWeight;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String pUserOpenId) {
        userOpenId = pUserOpenId;
    }
}
