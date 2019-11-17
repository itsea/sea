package com.taotaole.tws.mapper;

import com.taotaole.tws.bean.CommDetail;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
//@Component(value = "apiCategoryMapper")
public interface CommDetailMapper {

    //@Options(useGeneratedKeys = true,keyProperty = "cidcode")
    @Select("select * from CommDetail")
    public List<CommDetail> selectComm();

    @Options(useGeneratedKeys = true,keyProperty = "cidcode")
    @Insert("insert into commdetail(cname,ctitle,orgprice,cprice,cquality,caddress,phone,cnum,idcode) values(#{cname},#{ctitle},#{orgprice},#{cprice},#{cquality},#{caddress},#{phone},#{cnum},#{idcode})")
    public int insertComm(CommDetail commDetail);
//订单的改查数据库
    @Select("select * from commdetail where cidcode=#{cidcode}")
    public CommDetail selectOrderComm(Integer cidcode);

    @Update("update commdetail set cnum=cnum-1 where cidcode=#{cidcode}")
    public int updateComm(Integer cidcode);
}
