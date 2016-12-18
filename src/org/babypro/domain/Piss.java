package org.babypro.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Piss Class : 尿尿类
 * Created by johnzhu on 10/31/2016.
 */
@Entity
@Table(name = "piss")
public class Piss {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="piss_id")
    private int pissId;

    @Column(name="piss_currentTime")
    private Date pissCurrentTime;

    @Column(name="piss_weight")
    private String pissWeight;

    @Column(name="user_openid")
    private String userOpenId;


    public int getPissId() {
        return pissId;
    }

    public void setPissId(int pPissId) {
        pissId = pPissId;
    }

    public Date getPissCurrentTime() {
        return pissCurrentTime;
    }

    public void setPissCurrentTime(Date pPissCurrentTime) {
        pissCurrentTime = pPissCurrentTime;
    }

    public String getPissWeight() {
        return pissWeight;
    }

    public void setPissWeight(String pPissWeight) {
        pissWeight = pPissWeight;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String pUserOpenId) {
        userOpenId = pUserOpenId;
    }
}
