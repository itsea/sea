package com.taotaole.tws.mapper;

import com.taotaole.tws.bean.OrdUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
//@Component(value = "apiCategoryMapper")
public interface OrdUserMapper {

    @Options(useGeneratedKeys = true,keyProperty = "idCode")
    @Insert("insert into orduser(account,password) values(#{account},#{passWord})")
    public int insertUser(OrdUser ordUser);

    @Select("select * from orduser where account=#{account}")//and passWord=#{password}
    public OrdUser selectUserByAccount(String account);
//个人信息
    @Select("select * from orduser where idCode=#{idCode}")//and passWord=#{password}
    public OrdUser selectUserById(Integer idCode);
//判断是否存在
    @Select("select * from orduser where idCode=#{idCode}")//and passWord=#{password}
    public boolean judgeUserById(Integer idCode);


}
