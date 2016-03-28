package com.chales.dos.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chales.dos.dao.userLoginInfoMapper;
import com.chales.dos.entities.userLoginInfo;
import com.chales.dos.utils.MD5StringUtil;
import com.chalse.dos.baseClass.BaseResult;
import com.chalse.dos.baseClass.BeanResultDto;

@Service
public class LoginService {
	private static final Logger logger = Logger.getLogger(LoginService.class);
	@Autowired
	private userLoginInfoMapper userLoginInfoMapper;
	
	public BaseResult LoginCheck(String userLoginName,String userLoginPwd){
		BeanResultDto<userLoginInfo> resultDto = new BeanResultDto<userLoginInfo>();
		userLoginInfo info = userLoginInfoMapper.selectLoginUserInfo(userLoginName, MD5StringUtil.MD5Encode(userLoginPwd));
		if(info!=null){
			resultDto.setResult(info);
			resultDto.setSuccess(true);
		}else{
			resultDto.setResult(new userLoginInfo());
			resultDto.setSuccess(false);
		}
		return resultDto;
	}
}
