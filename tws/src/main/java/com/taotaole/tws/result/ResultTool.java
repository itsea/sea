package com.taotaole.tws.result;

import java.util.Map;

public class ResultTool {

    public static ResultModel result(int code, String message, Map<String,Object> map){
        ResultModel model=new ResultModel();
        model.setCode(code);
        switch(code){
            case 200:
                model.setMessage("success");
                if(map!=null){
                    model.setData(map);
                }
                break;
            case 101:
                model.setMessage("传参错误");
                break;
            case 404:
                model.setMessage(message);
                break;
            default:
                model.setMessage("未知错误");
                break;
        }
        return model;

    }
}
