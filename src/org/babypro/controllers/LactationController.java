package org.babypro.controllers;

import org.babypro.domain.Lactation;
import org.babypro.domain.User;
import org.babypro.service.ILactationService;
import org.babypro.service.IUserService;
import org.babypro.utils.AjaxResult;
import org.babypro.utils.JsonTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

        User user = mUserService.get((String)req.getAttribute("user_id"));
        pLactation.setUser(user);

        try {
            mLactationService.save(pLactation);
            aj = new AjaxResult(true,"save success");
        }catch (Exception pE){

        }

        return JsonTool.objToString(aj);
    }

    @RequestMapping(value="/lactation/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpServletRequest req ,@RequestBody Lactation pLactation){
        try {
            mLactationService.update(pLactation);
            aj = new AjaxResult(true,"update success");
        }catch (Exception pE){

        }

        return JsonTool.objToString(aj);
    }

    @RequestMapping(value="/lactation/delete/{lactationId}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable("lactationId") String pLactationId){
        try {
            mLactationService.delete(pLactationId);
            aj = new AjaxResult(true,"delete success");
        }catch (Exception pE){

        }

        return JsonTool.objToString(aj);
    }

    @RequestMapping(value="/lactation/get/{lactationId}", method = RequestMethod.POST)
    @ResponseBody
    public String get(@PathVariable("lactationId") String pLactationId){
        try {

//            a.add(JsonTool.objToString(mLactationService.get(Integer.valueOf(pLactationId))));
            aj = new AjaxResult(true,"get success",JsonTool.objToString(mLactationService.getAll()));
        }catch (Exception pE){

            System.out.println(pE.getMessage());
            System.out.println(pE);
        }

        return JsonTool.objToString(aj);
    }


}
