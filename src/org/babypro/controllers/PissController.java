package org.babypro.controllers;

import org.babypro.domain.Piss;
import org.babypro.domain.User;
import org.babypro.service.IPissService;
import org.babypro.service.IUserService;
import org.babypro.utils.AjaxResult;
import org.babypro.utils.JsonTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        try {
            mPissService.save(pPiss);
            aj = new AjaxResult(true, "save success");
        }catch (Exception pE){

        }

        return JsonTool.objToString(aj);
    }

    @RequestMapping(value="/piss/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpServletRequest req , @RequestBody Piss pPiss){

        try {
            mPissService.update(pPiss);
            aj = new AjaxResult(true, "update success");
        }catch (Exception pE){

        }

        return JsonTool.objToString(aj);
    }

    @RequestMapping(value="/piss/delete/{pissId}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable("pissId") String pPissId){
        try {
            mPissService.delete(pPissId);
            aj = new AjaxResult(true, "delete success");
        }catch (Exception pE) {

        }

        return JsonTool.objToString(aj);
    }


}
