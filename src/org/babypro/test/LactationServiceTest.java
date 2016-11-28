package org.babypro.test;

import com.google.gson.Gson;
import org.babypro.domain.Lactation;
import org.babypro.service.ILactationService;
import org.babypro.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by johnzhu on 10/27/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class LactationServiceTest {

    @Autowired
    ILactationService mLactationService;

    @Autowired
    IUserService mUserService;

    @Test
    public void save() throws Exception{



        Lactation lactation = new Lactation();
        lactation.setLactationCurrentTime(new Date());
        lactation.setLactationSide("Left");
        lactation.setLactationType("1");
        lactation.setLactationDuration(200);
        lactation.setUser(mUserService.get("E18011112222"));

        mLactationService.save(lactation);

    }

    @Test
    public void get() throws Exception {
        Lactation l = mLactationService.get(7);
        Gson gson = new Gson();
        String a = gson.toJson(l);
        System.out.println(a);
    }

    @Test
    public void getAll() throws Exception {
        List<Lactation> m = mLactationService.getAll();
        Gson gson = new Gson();
        String a = gson.toJson(m);
        System.out.println(a);
    }
}
