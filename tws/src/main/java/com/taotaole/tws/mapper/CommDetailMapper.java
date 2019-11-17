package com.taotaole.tws.mapper;

import com.taotaole.tws.bean.CommDetail;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
//@Component(value = "apiCategoryMapper")
public interface CommDetailMapper {

    @Options(useGeneratedKeys = true,keyProperty = "cidcode")
    @Select("select * from Commdetail")
    public List<CommDetail> selectComm();

    @Options(useGeneratedKeys = true,keyProperty = "cidcode")
    @Select("select * from CommDetail where cidcode=#{cidcode}")
    public CommDetail selectCommByID(Integer cidcode);

    @Options(useGeneratedKeys = true,keyProperty = "cidcode")
    @Insert("insert into commdetail(cname,ctitle,orgprice,cprice,cquality,caddress,cdeal,cnum,idcode) values(#{cname},#{ctitle},#{orgprice},#{cprice},#{cquality},#{caddress},#{cdeal},#{cnum},#{idcode})")
    public int insertComm(CommDetail commDetail);

}
