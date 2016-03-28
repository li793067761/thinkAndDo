package com.chales.dos.facade;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.chales.dos.service.LoginService;
import com.chalse.dos.baseClass.BaseResult;

@Path("/loginFacade")
public class LoginFacade {
	
	@Autowired
	private LoginService loginService;
	
	@GET
	@Path("/loginCheck")
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public BaseResult loginMethod(@QueryParam("userLoginName") String userLoginName,
			@QueryParam("userLoginPass") String userLoginPass){
		BaseResult resultDto = new BaseResult();
		if(StringUtils.isEmpty(userLoginName)){
			resultDto.setSuccess(false);
			return resultDto;
		}
		if(StringUtils.isEmpty(userLoginPass)){
			resultDto.setSuccess(false);
			return resultDto;
		}
		return loginService.LoginCheck(userLoginName, userLoginPass);
	}
}
