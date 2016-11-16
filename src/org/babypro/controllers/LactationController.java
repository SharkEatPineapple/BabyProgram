package org.babypro.controllers;

import com.google.gson.Gson;
import org.babypro.domain.Lactation;
import org.babypro.domain.User;
import org.babypro.service.ILactationService;
import org.babypro.service.IUserService;
import org.babypro.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 哺乳控制器
 * Created by johnzhu on 11/3/2016.
 */

@Controller
public class LactationController {

    @Autowired
    ILactationService mLactationService;
    @Autowired
    IUserService mUserService;

    private AjaxResult aj;

    @RequestMapping(value="/lactation/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(HttpServletRequest req ,@RequestBody Lactation pLactation){

        System.out.println("hello,world");

        System.out.println("id : " +req.getAttribute("user_id"));
//        InputStream is = null;
//        String requestBody = "";
//        try {
//            is = req.getInputStream();
//            requestBody= IOUtils.toString(is, "utf-8");
//        }catch(Exception e){
//
//        }

//        System.out.println(requestBody);
//        Gson gson = new Gson();
//        Lactation a = gson.fromJson(requestBody, Lactation.class);
//        System.out.println(a);

        User user = mUserService.get((String)req.getAttribute("user_id"));
        pLactation.setUser(user);
        mLactationService.save(pLactation);

        System.out.println(pLactation.getLactationSide());

        aj = new AjaxResult();
        aj.setSuccess(true);
        aj.setMessage("保存成功!");

        Gson gson = new Gson();
        String result = gson.toJson(aj);
        System.out.println("result");
        return result;
    }

    @RequestMapping(value="/lactation/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpServletRequest req ,@RequestBody Lactation pLactation){
        mLactationService.update(pLactation);

        aj = new AjaxResult();
        aj.setSuccess(true);
        aj.setMessage("modify success!!");
        Gson gson = new Gson();
        String result = gson.toJson(aj);
        System.out.println(result);
        return result;
    }

    @RequestMapping(value="/lactation/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(HttpServletRequest req ,@RequestBody Lactation pLactation){
        mLactationService.delete(pLactation.getLactationId());

        aj = new AjaxResult();
        aj.setSuccess(true);
        aj.setMessage("modify success!!");
        Gson gson = new Gson();
        String result = gson.toJson(aj);
        System.out.println(result);
        return result;
    }


}
