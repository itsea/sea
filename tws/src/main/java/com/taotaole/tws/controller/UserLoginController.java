package com.taotaole.tws.controller;

import com.taotaole.tws.bean.OrdUser;
import com.taotaole.tws.mapper.OrdUserMapper;
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
public class UserLoginController {
    @Autowired
    public OrdUserMapper ordUserMapper;

    @GetMapping("/login")
    public ResultModel selectUser(@RequestParam String account,
                                  @RequestParam String passWord){

        try {
            if(account.equals("")||passWord.equals("")){
                return ResultTool.result(101,"",null);
            }
            OrdUser ordUser=ordUserMapper.selectUserByAccount(account);//,passWord
            String acc=ordUser.getAccount();
            String ps=ordUser.getPassWord();

            Map<String,Object> map=new HashMap<String,Object>();
            if (ps.equals(passWord)) {
                map.put("id", ordUser.getIdCode());
                map.put("account", acc);
                return ResultTool.result(200, "", map);
            }
           else
            return ResultTool.result(101,"",null);
        }catch (Exception e){
            return ResultTool.result(404,"",null);
        }
    }

}
