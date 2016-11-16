package org.babypro.controllers;

import com.google.gson.Gson;
import org.babypro.domain.Piss;
import org.babypro.domain.User;
import org.babypro.service.IPissService;
import org.babypro.service.IUserService;
import org.babypro.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 尿尿控制器
 * Created by apple on 2016/11/15.
 */
public class PissController {

    @Autowired
    IUserService mUserService;

    @Autowired
    IPissService mPissService;

    private AjaxResult aj;

    @RequestMapping(value="/piss/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(HttpServletRequest req ,@RequestBody Piss pPiss){
        User user = mUserService.get((String)req.getAttribute("user_id"));
        pPiss.setUser(user);
        mPissService.save(pPiss);


        aj = new AjaxResult();
        aj.setSuccess(true);
        aj.setMessage("保存成功!");

        Gson gson = new Gson();
        String result = gson.toJson(aj);
        System.out.println("result");
        return result;
    }

    @RequestMapping(value="/piss/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpServletRequest req , @RequestBody Piss pPiss){

        mPissService.update(pPiss);

        aj = new AjaxResult();
        aj.setSuccess(true);
        aj.setMessage("modify success!!");

        Gson gson = new Gson();
        String result = gson.toJson(aj);
        System.out.println(result);
        return result;
    }

    @RequestMapping(value="/piss/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(HttpServletRequest req ,@RequestBody Piss pPiss){
        mPissService.delete(pPiss.getPissId());

        aj = new AjaxResult();
        aj.setSuccess(true);
        aj.setMessage("modify success!!");
        Gson gson = new Gson();
        String result = gson.toJson(aj);
        System.out.println(result);
        return result;
    }


}
