package com.taotaole.tws.controller;

import com.taotaole.tws.bean.OrdUser;
import com.taotaole.tws.mapper.OrdUserMapper;
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
public class UserController {

    @Autowired
    public OrdUserMapper ordUserMapper;
//注册
    @PostMapping("/register")
    public ResultModel insertUser(@RequestParam("account") String account,
                                  @RequestParam("passWord") String passWord){
        try {
            OrdUser ordUser = new OrdUser();
            ordUser.setAccount(account);
            ordUser.setPassWord(passWord);
            //判断


            ordUserMapper.insertUser(ordUser);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", ordUser.getIdCode());
            map.put("account",ordUser.getAccount());
            return ResultTool.result(200, "", map);
        }catch (Exception e){
            return ResultTool.result(404,"",null);
        }
    }
//个人信息
    @GetMapping("/userdetail")
    public ResultModel insertUser(@RequestParam("idCode") Integer idCode){
        try {
            OrdUser ordUser;// = new OrdUser();
            //判断有无该用户
            if(ordUserMapper.selectUserById(idCode)==null) return ResultTool.result(101, "", null);

            ordUser=ordUserMapper.selectUserById(idCode);
            ordUser.getPhonenum();
            List<Object> list = new ArrayList<Object>();
            list.add(ordUser.getIdCode());
            list.add(ordUser.getAccount());

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("idCode",ordUser.getIdCode());
            map.put("account",ordUser.getAccount());
            // map.put("account",ordUser.getAccount());
            return ResultTool.result(200, "", map);
        }catch (Exception e){
            return ResultTool.result(404,"",null);
        }
    }


}
