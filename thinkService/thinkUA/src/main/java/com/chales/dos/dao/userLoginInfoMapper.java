package com.chales.dos.dao;

import com.chales.dos.entities.userLoginInfo;
import com.chales.dos.entities.userLoginInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface userLoginInfoMapper {
    int countByExample(userLoginInfoExample example);

    int deleteByExample(userLoginInfoExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(userLoginInfo record);

    int insertSelective(userLoginInfo record);

    List<userLoginInfo> selectByExample(userLoginInfoExample example);

    userLoginInfo selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") userLoginInfo record, @Param("example") userLoginInfoExample example);

    int updateByExample(@Param("record") userLoginInfo record, @Param("example") userLoginInfoExample example);

    int updateByPrimaryKeySelective(userLoginInfo record);

    int updateByPrimaryKey(userLoginInfo record);
    
    userLoginInfo selectLoginUserInfo(@Param("userLoginName") String userLoginName,@Param("userLoginPwd") String userLoginPwd);
}