package com.taotaole.tws.controller;

import com.taotaole.tws.bean.*;
import com.taotaole.tws.mapper.CommDetailMapper;

import com.taotaole.tws.result.ResultModel;
import com.taotaole.tws.result.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class CommController {

    @Autowired
    public CommDetailMapper commDetailMapper;
//商品list
    @GetMapping("/goodslist")
    public ResultModel selectComm(){

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            List<CommDetail> commDetails =commDetailMapper.selectComm();

            map.put("goods", commDetails);

            return ResultTool.result(200, "", map);
        } catch (Exception e)
        {return ResultTool.result(404, e.getMessage(), null);}

    }

    //商品detail
    @GetMapping("/goodsdetail")
    public ResultModel selectdetail(@RequestParam("cidcode") Integer cidcode){

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            CommDetail commDetails =commDetailMapper.selectOrderComm(cidcode);
            map.put("goods", commDetails);

            return ResultTool.result(200, "", map);
        } catch (Exception e)
        {return ResultTool.result(404, e.getMessage(), null);}
    }



}
