package com.taotaole.tws.controller;

import com.taotaole.tws.bean.CommDetail;
import com.taotaole.tws.mapper.CommDetailMapper;
import com.taotaole.tws.result.ResultModel;
import com.taotaole.tws.result.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class CommUpLoadController {
    @Autowired
    public CommDetailMapper commDetailMapper2;

    @PostMapping("/upload")
    public ResultModel insertCommodity(@RequestParam("cname") String cname,
                                       @RequestParam("ctitle") String ctitle,
                                       @RequestParam("orgprice") String orgprice,
                                       @RequestParam("cprice") String cprice,
                                       @RequestParam("cquality") String cquality,
                                       @RequestParam("caddress") String caddress,
                                       @RequestParam("phone") String phone,
                                       @RequestParam("cnum") String cnum,
                                       @RequestParam("idcode") Integer idcode){

        double orgprice1=Double.parseDouble(orgprice);
        double cprice1=Double.parseDouble(cprice);
        Integer cnum1=Integer.parseInt(cnum);
        try{


            CommDetail commDetail=new CommDetail();

            commDetail.setCname(cname);
            commDetail.setCtitle(ctitle);

            commDetail.setOrgprice(orgprice1);

            commDetail.setCprice(cprice1);
            commDetail.setCquality(cquality);
            commDetail.setCaddress(caddress);
            commDetail.setPhone(phone);

            commDetail.setCnum(cnum1);
            commDetail.setIdcode(idcode);

            try {

                commDetailMapper2.insertComm(commDetail);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("goods", commDetail);
                return ResultTool.result(200, "", map);

            }catch (Exception e1){return ResultTool.result(101, "", null);}


        }catch (Exception e){
            return ResultTool.result(404,"",null);}
    }
}
