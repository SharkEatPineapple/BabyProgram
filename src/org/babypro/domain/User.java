package org.babypro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by johnzhu on 10/27/2016.
 */
@Entity
@Table(name = "user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="user_openid")
    private String openid;

    @Column(name="user_nickname")
    private String nickName;

    @Column(name="user_pic")
    private String pic;

    @Column(name="user_gender")
    private int gender;

    @Column(name="user_position")
    private String position;


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String pOpenid) {
        openid = pOpenid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String pNickName) {
        nickName = pNickName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pPic) {
        pic = pPic;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int pGender) {
        gender = pGender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String pPosition) {
        position = pPosition;
    }
}

