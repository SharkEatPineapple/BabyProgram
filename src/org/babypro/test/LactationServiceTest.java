package org.babypro.test;

import com.google.gson.Gson;
import org.babypro.domain.Lactation;
import org.babypro.service.ILactationService;
import org.babypro.service.IUserService;
import org.babypro.utils.JsonTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        lactation.setLactationSide("Right");
        lactation.setLactationType("2");
        lactation.setLactationDuration(100);
        lactation.setUserOpenId("test2");

        mLactationService.save(lactation);

    }

    @Test
    public void get() throws Exception {
        String hql = "from Lactation l where l.lactationId=:lactationId and l.userOpenId=:userOpenId";
        Map<String,Object> params = new HashMap<>();
        params.put("lactationId",2);
        params.put("userOpenId","test");
//        params.put("user_openid","test");
        Lactation l = mLactationService.get(hql,params);

        String a = JsonTool.objToString(l);
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
