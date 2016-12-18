package org.babypro.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Feces Class : 喂奶类
 *
 * Created by johnzhu on 11/3/2016.
 */

@Entity
@Table(name = "lactation")
public class Lactation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="lactation_id")
    private int lactationId;

    @Column(name="lactation_currentTime")
    private Date lactationCurrentTime;

    @Column(name="lactation_duration") //时长
    private int lactationDuration;

    @Column(name="lactation_type")
    private String lactationType;

    @Column(name="lactation_side")
    private String lactationSide;

    @Column(name="lactation_amount")
    private int lactationAmount;

    @Column(name="user_openid")
    private String userOpenId;


    public int getLactationId() {
        return lactationId;
    }

    public void setLactationId(int pLactationId) {
        lactationId = pLactationId;
    }

    public Date getLactationCurrentTime() {
        return lactationCurrentTime;
    }

    public void setLactationCurrentTime(Date pLactationCurrentTime) {
        lactationCurrentTime = pLactationCurrentTime;
    }

    public int getLactationDuration() {
        return lactationDuration;
    }

    public void setLactationDuration(int pLactationDuration) {
        lactationDuration = pLactationDuration;
    }

    public String getLactationType() {
        return lactationType;
    }

    public void setLactationType(String pLactationType) {
        lactationType = pLactationType;
    }

    public String getLactationSide() {
        return lactationSide;
    }

    public void setLactationSide(String pLactationSide) {
        lactationSide = pLactationSide;
    }

    public int getLactationAmount() {
        return lactationAmount;
    }

    public void setLactationAmount(int pLactationAmount) {
        lactationAmount = pLactationAmount;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String pUserOpenId) {
        userOpenId = pUserOpenId;
    }
}
