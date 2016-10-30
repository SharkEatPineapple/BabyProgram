package org.babypro.test;

import org.babypro.domain.Piss;
import org.babypro.service.IPissService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by johnzhu on 10/27/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PissServiceTest {

    @Autowired
    IPissService mPissService;

    @Test
    public void save() throws Exception{
        Piss piss = new Piss();
        Date date = new Date();
        System.out.println(date);
        piss.setPissCurrentTime(date);
        piss.setPissWeight("heklklo");
        mPissService.save(piss);
    }
}
