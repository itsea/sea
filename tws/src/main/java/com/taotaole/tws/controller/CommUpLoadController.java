package com.taotaole.tws.controller;

import com.taotaole.tws.bean.CommDetail;
import com.taotaole.tws.mapper.CommDetailMapper;
import com.taotaole.tws.result.ResultModel;
import com.taotaole.tws.result.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommUpLoadController {
    @Autowired
    public CommDetailMapper commDetailMapper2;

    @PostMapping("/upload")
    public ResultModel insertCommodity(@RequestParam("cname") String cname,
                                       @RequestParam("ctitle") String ctitle,
                                       @RequestParam("orgprice") double orgprice,
                                       @RequestParam("cprice") double cprice,
                                       @RequestParam("cquality") String cquality,
                                       @RequestParam("caddress") String caddress,
                                       @RequestParam("cdeal") String phone,
                                       @RequestParam("cnum") Integer cnum,
                                       @RequestParam("idcode") Integer idcode){
        try{
            CommDetail commDetail=new CommDetail();

            commDetail.setCname(cname);
            commDetail.setCtitle(ctitle);
            commDetail.setOrgprice(orgprice);
            commDetail.setCprice(cprice);
            commDetail.setCquality(cquality);
            commDetail.setCaddress(caddress);
            commDetail.setPhone(phone);
            commDetail.setCnum(cnum);
            commDetail.setIdcode(idcode);

            try {

                commDetailMapper2.insertComm(commDetail);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("cidcode", commDetail.getCidcode());
                return ResultTool.result(200, "", map);

            }catch (Exception e1){return ResultTool.result(101, "", null);}


        }catch (Exception e){
            return ResultTool.result(404,"",null);}
    }
}
