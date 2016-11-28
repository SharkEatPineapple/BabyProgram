package org.babypro.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by johnzhu on 10/27/2016.
 */
@Entity
@Table(name = "user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="user_uid")
    private String uid;

    @Column(name="user_nickname")
    private String nickName;

    @Column(name="user_openid")
    private String openid;


    public String getUid() {
        return uid;
    }

    public void setUid(String pUid) {
        uid = pUid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String pNickName) {
        nickName = pNickName;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String pOpenid) {
        openid = pOpenid;
    }
}

