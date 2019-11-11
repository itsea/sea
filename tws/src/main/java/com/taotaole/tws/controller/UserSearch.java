package com.taotaole.tws.controller;

import com.taotaole.tws.bean.CommDetail;
import com.taotaole.tws.bean.OrdUser;
import com.taotaole.tws.mapper.OrdUserMapper;
import com.taotaole.tws.mapper.UserSearchMapper;
import com.taotaole.tws.result.ResultModel;
import com.taotaole.tws.result.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
public class UserSearch {
    @Autowired
    public OrdUserMapper ordUserMapper;
    public UserSearchMapper userSearchMapper;

/*     //获取用户上传的商品列表
    @PostMapping("/selllist")
   public ResultModel insertUser(@RequestParam("idCode") Integer idCode){

       try {
            Map<String, Object> map = new HashMap<String, Object>();
            List<CommDetail> selllist=userSearchMapper.selectUserUploadlist(idCode);
            map.put("id", ordUser.getIdCode());
            map.put("account",ordUser.getAccount());
            return ResultTool.result(200, "", map);
        }catch (Exception e){
            return ResultTool.result(404,"",null);
        }
    }

    //获得用户已购买的列表
    @PostMapping("/buylist")
    public ResultModel insertUser(@RequestParam("idCode") Integer idCode){
        try {
            OrdUser ordUser = new OrdUser();
            ordUser.setAccount(account);
            ordUser.setPassWord(passWord);
            ordUserMapper.insertUser(ordUser);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", ordUser.getIdCode());
            map.put("account",ordUser.getAccount());
            return ResultTool.result(200, "", map);
        }catch (Exception e){
            return ResultTool.result(404,"",null);
        }
    }*/

}
