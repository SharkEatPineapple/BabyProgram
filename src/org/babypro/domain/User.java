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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer mId;

    @Column(name="uuid")
    private String mUUId;

    @Column(name="phoneNum")
    private String mPhoneNum;


    public Integer getId() {
        return mId;
    }

    public void setId(Integer pId) {
        mId = pId;
    }

    public String getUUId() {
        return mUUId;
    }

    public void setUUId(String pUUId) {
        mUUId = pUUId;
    }

    public String getPhoneNum() {
        return mPhoneNum;
    }

    public void setPhoneNum(String pPhoneNum) {
        mPhoneNum = pPhoneNum;
    }
}

