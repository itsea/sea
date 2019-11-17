package com.taotaole.tws.controller;

import com.taotaole.tws.bean.CommDetail;
import com.taotaole.tws.bean.CommOrder;
import com.taotaole.tws.mapper.CommodityMapper;
import com.taotaole.tws.result.ResultModel;
import com.taotaole.tws.result.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderCommController {
    @Autowired
    public CommodityMapper commodityMapper;

    @PostMapping("/order")
    public ResultModel insertOrder(@RequestParam("idcode") Integer idcode,
                                   @RequestParam("cidcode") Integer cidcode){
        try {
            CommOrder commOrder=new CommOrder();
            commOrder.setIdcode(idcode);
            commOrder.setCidcode(cidcode);
            commodityMapper.insertOrderComm(commOrder);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id",commOrder.getCid() );
            return ResultTool.result(200, "", map);
        }catch(Exception e){return ResultTool.result(404,"",null);}
    }
}
