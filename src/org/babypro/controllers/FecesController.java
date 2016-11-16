package org.babypro.controllers;

import com.google.gson.Gson;
import org.babypro.domain.Feces;
import org.babypro.domain.User;
import org.babypro.service.IFecesService;
import org.babypro.service.IUserService;
import org.babypro.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 臭臭控制器
 * Created by apple on 2016/11/15.
 */
public class FecesController {

    @Autowired
    IUserService mUserService;

    @Autowired
    IFecesService mFecesService;

    private AjaxResult aj;

    @RequestMapping(value="/feces/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(HttpServletRequest req ,@RequestBody Feces pFeces){
        User user = mUserService.get((String)req.getAttribute("user_id"));
        pFeces.setUser(user);
        mFecesService.save(pFeces);


        aj = new AjaxResult();
        aj.setSuccess(true);
        aj.setMessage("保存成功!");

        Gson gson = new Gson();
        String result = gson.toJson(aj);
        System.out.println("result");
        return result;
    }

    @RequestMapping(value="/feces/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpServletRequest req , @RequestBody Feces pFeces){

        mFecesService.update(pFeces);

        aj = new AjaxResult();
        aj.setSuccess(true);
        aj.setMessage("modify success!!");

        Gson gson = new Gson();
        String result = gson.toJson(aj);
        System.out.println(result);
        return result;
    }

    @RequestMapping(value="/feces/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(HttpServletRequest req ,@RequestBody Feces pFeces){
        mFecesService.delete(pFeces.getPissId());

        aj = new AjaxResult();
        aj.setSuccess(true);
        aj.setMessage("modify success!!");
        Gson gson = new Gson();
        String result = gson.toJson(aj);
        System.out.println(result);
        return result;
    }


}
