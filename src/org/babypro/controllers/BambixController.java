package org.babypro.controllers;

import org.babypro.domain.Bambix;
import org.babypro.service.IBambixService;
import org.babypro.service.IFoodService;
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
        String openId = (String)req.getAttribute("open_id");


        try {
            pBambix.setUserOpenId(openId);
            mBambixService.save(pBambix);
            aj = new AjaxResult(true,"save success");
        }catch (Exception pE){

        }

        return JsonTool.objToString(aj);
    }

    @RequestMapping(value="/bambix/update/", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpServletRequest req , @RequestBody Bambix pBambix){

        mBambixService.update(pBambix);

        return null;
    }

    @RequestMapping(value="/bambix/delete/{bambixId}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable("bambixId") String pBambixId){

        mBambixService.delete(pBambixId);

        return null;
    }


}
