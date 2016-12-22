package org.babypro.controllers;

import org.babypro.domain.Lactation;
import org.babypro.service.ILactationService;
import org.babypro.service.IUserService;
import org.babypro.utils.AjaxResult;
import org.babypro.utils.JsonTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

        String openId = (String)req.getAttribute("open_id");

        try {
            pLactation.setUserOpenId(openId);
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
    public String get(HttpServletRequest req, @PathVariable("lactationId") Integer pLactationId){
        String openId = (String)req.getAttribute("open_id");
        try {
            String hql = "from Lactation l where l.lactationId=:lactationId and l.userOpenId=:userOpenId";
            Map<String,Object> params = new HashMap<>();
            params.put("lactationId",pLactationId);
            params.put("userOpenId",openId);
            Lactation lactation = mLactationService.get(hql,params);
            String result = JsonTool.objToString(lactation);
            System.out.println(result);

            aj = new AjaxResult(true,"get success",result);
        }catch (Exception pE){

            System.out.println(pE.getMessage());
            System.out.println(pE);
            aj = new AjaxResult(false,"get failed, the reason is :"+pE);
        }

        return JsonTool.objToString(aj);
    }


}
