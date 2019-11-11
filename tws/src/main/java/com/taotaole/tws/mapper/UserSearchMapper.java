package com.taotaole.tws.mapper;

import com.taotaole.tws.bean.CommDetail;
import com.taotaole.tws.bean.Commodity;
import com.taotaole.tws.bean.OrdUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
//@Component(value = "apiCategoryMapper")
public interface UserSearchMapper {


    //获取用户上传的商品列表
    @Select("select * from Commdetail where idCode=#{idCode}")//and passWord=#{password}
    public List<CommDetail> selectUserUploadlist(Integer idCode);

    //获得用户已购买的列表
    @Select("select * from Commodity where idCode=#{idCode}")//and passWord=#{password}
    public List<Commodity> selectUserBuylist(Integer idCode);

}
