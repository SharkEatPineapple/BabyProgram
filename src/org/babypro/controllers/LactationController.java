package org.babypro.controllers;

import org.babypro.domain.Lactation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by johnzhu on 11/3/2016.
 */

@Controller
public class LactationController {

    @RequestMapping(value="/lactation/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody Lactation req){

        System.out.println("hello,world");
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

        System.out.println(req.getLactationSide());
        return "success";
    }
}
