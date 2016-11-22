package org.babypro.controllers;

import com.google.gson.Gson;
import org.babypro.domain.Bambix;
import org.babypro.domain.Feces;
import org.babypro.domain.Food;
import org.babypro.domain.User;
import org.babypro.service.IBambixService;
import org.babypro.service.IFoodService;
import org.babypro.service.IUserService;
import org.babypro.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 臭臭控制器
 * Created by apple on 2016/11/15.
 */
public class BambixController {

    @Autowired
    IUserService mUserService;

    @Autowired
    IBambixService mBambixService;

    @Autowired
    IFoodService mFoodService;

    private AjaxResult aj;

    @RequestMapping(value="/bambix/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(HttpServletRequest req ,@RequestBody Bambix pBambix){
        User user = mUserService.get((String)req.getAttribute("user_id"));
        pBambix.setUser(user);

        Food food = pBambix.getFood();
        food.setUser(user);
        mFoodService.save(food);


        pBambix.setFood(food);

        mBambixService.save(pBambix);

        aj = new AjaxResult();
        aj.setSuccess(true);
        aj.setMessage("保存成功!");

        Gson gson = new Gson();
        String result = gson.toJson(aj);
        System.out.println("result");
        return result;
    }

    @RequestMapping(value="/bambix/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpServletRequest req , @RequestBody Bambix pBambix){


    }

    @RequestMapping(value="/bambix/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(HttpServletRequest req ,@RequestBody Bambix pBambix){

    }


}
