package org.babypro.test;

import org.babypro.domain.Food;
import org.babypro.service.IFoodService;
import org.babypro.service.IUserService;
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
public class FoodServiceTest {

    @Autowired
    IFoodService mFoodService;

    @Autowired
    IUserService mUserService;

    @Test
    public void save() throws Exception{

        Food food = new Food();
        food.setFoodName("水果");
        food.setFoodMessage("苹果");


        mFoodService.save(food);

    }

    @Test
    public void get() throws Exception {


    }
}
