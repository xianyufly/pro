package com.sobt.pro.constant;

import com.alibaba.fastjson.JSONObject;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public enum MsgEnum {
	/**
	 * 错误码规则:
	 * 
		第1位	2~5位	
	      2	         0000	     
         第1位: 错误提示级别，1:提示 2:不提示
         第2~5位:	具体错误代码
	 */
	/*
	 *--------------------------------------模块:1------------------------------------------------- 
	 */
	/**
	 *  代码:10000
	 *  代码说明:提示 操作成功
	 */
	Success("操作成功",10000)
	/**
	 *  代码:10001
	 *  代码说明:提示 账号不可用
	 */
	,Account_Disabled("账号不可用",10001)
	/**
	 *  代码:10002
	 *  代码说明:提示 账号已被锁定
	 */
	,Account_Locked("账号已被锁定",10002)
	/**
	 *  代码:10003
	 *  代码说明:提示 账号或者密码错误
	 */
	,Account_BadCredentials("账号或者密码错误",10003)
	/**
	 *  代码:10004
	 *  代码说明:提示 refreshToken过期或refreshToken错误
	 */
	,Refresh_Token_Error("refreshToken过期或refreshToken错误",10004)
	/**
	 *  代码:10005
	 *  代码说明:提示 refreshToken过期或refreshToken错误
	 */
	,Account_ReEntry("请重新登录",10005)
	/**
	 *  代码:10006
	 *  代码说明:提示 token 超时,请刷新token
	 */
	,Token_Expired("token 超时,请刷新token",10006)
	/**
	 *  代码:10007
	 *  代码说明:提示 token 超时,请刷新token
	 */
	,Token_Error("token 非法",10007)
	/**
	 *  代码:10008
	 *  代码说明:提示 token 参数非法
	 */
	,Param_Error("参数非法",10008)
	/**
	 *  代码:10009
	 *  代码说明:提示 refresh token 超时,请重新登录
	 */
	,RefreshToken_Expired("refresh token 超时,请重新登录",10009)
	/**
	 *  代码:10010
	 *  代码说明:提示 refresh token 非法
	 */
	,RefreshToken_Error("refresh token 非法",10010)
	/**
	 *  代码:10011
	 *  代码说明:提示 未购买，无法进行操作
	 */
	,Unpay_Error("未购买，无法进行操作",10011)
	/**
	 *  代码:10012
	 *  代码说明:提示 验证码错误
	 */
	,Auth_Code_Error("验证码错误",10012)
	
	/*
	 *--------------------------------------模块:1结束------------------------------------------------- 
	 */
	
	/*
	 *--------------------------------------模块:2------------------------------------------------- 
	 */
	/**
	 *  代码:20001
	 *  代码说明:不提示 内部未处理异常
	 */
	,Error("系统异常",20001)
	/**
	 *  代码:20002
	 *  代码说明:不提示 未授权调用
	 */
	,Api_UnAuth("未授权调用",20002)
	/**
	 *  代码:20003
	 *  代码说明:不提示 权限不足，无法调用该方法
	 */
	,Api_METHOD_NOT_ALLOWED("权限不足，无法调用该方法",20003)
	/**
	 *  代码:20004
	 *  代码说明:不提示 方法不存在
	 */
	,Api_METHOD_NOT_FOUND("方法不存在",20004)
	;
	
	
	
	
	
	/*
	 *--------------------------------------模块:2 结束------------------------------------------------- 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	// 成员变量  
    private String msg;  
    private int code;  
    // 构造方法  
    private MsgEnum(String msg, int code) {  
        this.msg = msg;  
        this.code = code;  
    }  
    
    public String getMsg() {  
        return msg;  
    }  

    public int getCode() {  
        return code;  
    }  
    
    public String getMsg(BindingResult result) {
    	if(result.hasErrors()){
    		List<ObjectError> beList=result.getAllErrors();
    		List<String> errorMap=new ArrayList<>();
    		for(ObjectError ob:beList){
    			errorMap.add(ob.getDefaultMessage());
    		}
    		return JSONObject.toJSONString(errorMap);
    	}else{
    		return msg;  
    	}
        
    }

}
