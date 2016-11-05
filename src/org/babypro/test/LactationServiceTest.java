package org.babypro.test;

import java.util.Date;

import org.babypro.domain.Feces;
import org.babypro.service.IFecesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by johnzhu on 10/27/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class LactationServiceTest {

    @Autowired
    IFecesService mFecesService;

    @Test
    public void save() throws Exception{
        Feces feces = new Feces();
        feces.setFecesCurrentTime(new Date());
        feces.setFecesStatus(0);
        feces.setFecesWeight("100");
        mFecesService.save(feces);

    }
}
