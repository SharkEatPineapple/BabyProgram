package org.babypro.utils;

import com.google.gson.Gson;

/**
 * Created by johnzhu on 11/28/2016.
 */
public  class  JsonTool {

    public static String objToString(Object object){
        Gson gson = new Gson();
        String result = gson.toJson(object);
        return result;
    }


}
