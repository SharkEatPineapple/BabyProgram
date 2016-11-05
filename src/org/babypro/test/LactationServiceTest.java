package org.babypro.test;

import org.babypro.domain.Lactation;
import org.babypro.domain.User;
import org.babypro.service.ILactationService;
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
public class LactationServiceTest {

    @Autowired
    ILactationService mLactationService;

    @Test
    public void save() throws Exception{
        User user = new User();
        user.setUid("E18033332222");
        user.setNickName("DDD");
        user.setOpenid("openId");


        Lactation lactation = new Lactation();
        lactation.setLactationAmount(100);
        lactation.setLactationCurrentTime(new Date());
        lactation.setLactationSide("Left");
        lactation.setLactationType("1");
        lactation.setLactationDuration(200);
        lactation.setUser(user);

        mLactationService.save(lactation);

    }
}
