package org.babypro.test;

import com.google.gson.Gson;
import org.babypro.domain.Bambix;
import org.babypro.service.IBambixService;
import org.babypro.service.IFoodService;
import org.babypro.service.IUserService;
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
public class BambixServiceTest {

    @Autowired
    IFoodService mFoodService;

    @Autowired
    IUserService mUserService;

    @Autowired
    IBambixService mBambixService;

    @Test
    public void save() throws Exception{



        Bambix bambix = new Bambix();
        bambix.setBambixCurrentTime(new Date());
        bambix.setBambixWeight("100");
        bambix.setFood(mFoodService.get(1));
        bambix.setUser(mUserService.get("E18011112222"));

        mBambixService.save(bambix);

    }

    @Test
    public void get() throws Exception {

        Gson gson = new Gson();
        String result = gson.toJson(mBambixService.get(1));
        System.out.println(result);


    }
}
