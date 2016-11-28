package org.babypro.controllers;

import org.babypro.domain.Food;
import org.babypro.domain.User;
import org.babypro.service.IFoodService;
import org.babypro.service.IUserService;
import org.babypro.utils.AjaxResult;
import org.babypro.utils.JsonTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 食物控制器
 * Created by apple on 2016/11/15.
 */
public class FoodController {

    @Autowired
    IUserService mUserService;

    @Autowired
    IFoodService mFoodService;

    private AjaxResult aj;

    @RequestMapping(value="/food/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(HttpServletRequest req ,@RequestBody Food pFood){
        User user = mUserService.get((String)req.getAttribute("user_id"));
        pFood.setUser(user);

        try {
            mFoodService.save(pFood);
            aj = new AjaxResult(true, "save success");
        }catch (Exception pE){

        }

        return JsonTool.objToString(aj);
    }

    @RequestMapping(value="/food/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpServletRequest req , @RequestBody Food pFood){

        try {
            mFoodService.update(pFood);
            aj = new AjaxResult(true, "update success");
        }catch (Exception pE){

        }

        return JsonTool.objToString(aj);
    }

    @RequestMapping(value="/food/delete/{foodId}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable("foodId") String pFoodId){
        try {
            mFoodService.delete(pFoodId);
            aj = new AjaxResult(true, "delete success");
        }catch (Exception pE) {

        }

        return JsonTool.objToString(aj);
    }


    @RequestMapping(value="/food/get/{foodId}", method = RequestMethod.POST)
    @ResponseBody
    public String get(@PathVariable("foodId") String pFoodId){
        try {
            aj = new AjaxResult(true, "get success",JsonTool.objToString(mFoodService.get(Integer.valueOf(pFoodId))));
        }catch (Exception pE) {

        }

        return JsonTool.objToString(aj);
    }

    @RequestMapping(value="/food/get/all", method = RequestMethod.POST)
    @ResponseBody
    public String getAll(){
        try {
            aj = new AjaxResult(true, "get all success",JsonTool.objToString(mFoodService.getAll()));
        }catch (Exception pE) {

        }

        return JsonTool.objToString(aj);
    }

}
