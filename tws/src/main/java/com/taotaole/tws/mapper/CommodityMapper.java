package com.taotaole.tws.mapper;

import com.taotaole.tws.bean.CommDetail;
import com.taotaole.tws.bean.CommOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface CommodityMapper {

    @Options(useGeneratedKeys = true,keyProperty = "cid")
    @Insert("insert into commodity(idcode,cidcode) values(#{idcode},#{cidcode})")
    public int insertOrderComm(CommOrder commOrder);
}
