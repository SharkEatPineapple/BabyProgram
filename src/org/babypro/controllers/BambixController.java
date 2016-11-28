package org.babypro.controllers;

import org.babypro.domain.Bambix;
import org.babypro.domain.User;
import org.babypro.service.IBambixService;
import org.babypro.service.IFoodService;
import org.babypro.service.IUserService;
import org.babypro.utils.AjaxResult;
import org.babypro.utils.JsonTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

        try {
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
