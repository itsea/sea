package com.taotaole.tws.controller;

import com.taotaole.tws.bean.CommDetail;
import com.taotaole.tws.bean.CommOrder;
import com.taotaole.tws.mapper.UserSearchMapper;
import com.taotaole.tws.result.ResultModel;
import com.taotaole.tws.result.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserSearch {
    @Autowired

    public UserSearchMapper userSearchMapper;

     //获取用户上传的商品列表
    @GetMapping("/selllist")
   public ResultModel sellList(@RequestParam("idcode") Integer idCode){

       try {
            Map<String, Object> map = new HashMap<String, Object>();
            List<CommDetail> selllist=userSearchMapper.selectUserUploadlist(idCode);
            map.put("list", selllist);
            //map.put("account",ordUser.getAccount());
            return ResultTool.result(200, "", map);
        }catch (Exception e){
            return ResultTool.result(404,"",null);
        }
    }

    //获得用户已购买的列表
    @GetMapping("/buylist")
    public ResultModel buyList(@RequestParam("idcode") Integer idCode){
        try {
            //获取用户订单
            List<CommOrder> commodityList=userSearchMapper.selectUserCommoditylist(idCode);
            //List<Integer> list = new ArrayList<String>();


   //根据订单中的商品id获取商品信息

            CommDetail commDetail ;
            Map<String, Object> map = new HashMap<String, Object>();
            List<CommDetail> buylist=new ArrayList<CommDetail>();
            List list = new ArrayList();

            for(int i = 0; i < commodityList.size();i++)
            {

            commDetail =userSearchMapper.selectUserBuylist(commodityList.get(i).getCidcode());

                Map<String, Object> map1 = new HashMap<String, Object>();
                //buylist.add(commDetail);
                map1.put("CId",commodityList.get(i).getCid());
                map1.put("commodity",commDetail);
                list.add(map1);

        }
            map.put("list",list);

            return ResultTool.result(200, "", map);
        }catch (Exception e){
            return ResultTool.result(404,"",null);
        }
    }

}
