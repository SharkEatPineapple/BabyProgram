package org.babypro.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Feces Class : 臭臭类
 *
 * Created by johnzhu on 10/31/2016.
 */

@Entity
@Table(name = "feces")
public class Feces {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="feces_id")
    private int pissId;

    @Column(name="feces_currentTime")
    private Date fecesCurrentTime;

    @Column(name="feces_status")
    private int fecesStatus;

    @Column(name="feces_weight")
    private String fecesWeight;


    public int getPissId() {
        return pissId;
    }

    public void setPissId(int pPissId) {
        pissId = pPissId;
    }

    public Date getFecesCurrentTime() {
        return fecesCurrentTime;
    }

    public void setFecesCurrentTime(Date pFecesCurrentTime) {
        fecesCurrentTime = pFecesCurrentTime;
    }

    public int getFecesStatus() {
        return fecesStatus;
    }

    public void setFecesStatus(int pFecesStatus) {
        fecesStatus = pFecesStatus;
    }

    public String getFecesWeight() {
        return fecesWeight;
    }

    public void setFecesWeight(String pFecesWeight) {
        fecesWeight = pFecesWeight;
    }
}
