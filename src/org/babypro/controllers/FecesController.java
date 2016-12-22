package org.babypro.controllers;

import org.babypro.domain.Feces;
import org.babypro.service.IFecesService;
import org.babypro.service.IUserService;
import org.babypro.utils.AjaxResult;
import org.babypro.utils.JsonTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 臭臭控制器
 * Created by apple on 2016/11/15.
 */
@Controller
public class FecesController {

    @Autowired
    IUserService mUserService;

    @Autowired
    IFecesService mFecesService;

    private AjaxResult aj;

    @RequestMapping(value="/feces/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(HttpServletRequest req ,@RequestBody Feces pFeces){
        String openId = (String)req.getAttribute("open_id");
        try {
            pFeces.setUserOpenId(openId);
            mFecesService.save(pFeces);
            aj = new AjaxResult(true,"save success");
        }catch (Exception pE){

        }

        return JsonTool.objToString(aj);
    }

    @RequestMapping(value="/feces/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpServletRequest req , @RequestBody Feces pFeces){

        try {
            mFecesService.update(pFeces);
            aj = new AjaxResult(true,"update success");
        }catch (Exception pE){

        }

        return JsonTool.objToString(aj);
    }

    @RequestMapping(value="/feces/delete/{fecesId}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable("fecesId") String pFecesId){

        try {
            mFecesService.delete(pFecesId);
            aj = new AjaxResult(true,"delete success");
        }catch (Exception pE){

        }
        return JsonTool.objToString(aj);
    }


}
