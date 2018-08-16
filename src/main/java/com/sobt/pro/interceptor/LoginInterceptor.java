package com.sobt.pro.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.dao.bean.TUser;
import com.sobt.pro.vo.SuccessBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginInterceptor implements HandlerInterceptor {

    private static class SendMsgUtil {

        /**
         * 发送消息 text/html;charset=utf-8
         * @param response
         * @param str
         * @throws Exception
         */
        public static void sendMessage(HttpServletResponse response, String str) throws Exception {
            response.setContentType("text/html; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(str);
            writer.close();
            response.flushBuffer();
        }

        /**
         * 将某个对象转换成json格式并发送到客户端
         * @param response
         * @param obj
         * @throws Exception
         */
        public static void sendJsonMessage(HttpServletResponse response, Object obj) throws Exception {
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(JSONObject.toJSONString(obj, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteDateUseDateFormat));
            writer.close();
            response.flushBuffer();
        }
    }



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session=request.getSession();
        String url = request.getRequestURI();
        String regEx = "^.*/plat/.*$";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(url);
        System.out.println(matcher.matches());
        if(matcher.matches()){
            TUser user=(TUser)session.getAttribute("user");
            System.out.println(request.getMethod());
            if(user==null&&!"OPTIONS".equals(request.getMethod())){
                //response 返回 401
                response.setStatus(401);
                SuccessBean result=new SuccessBean<>();
                result.setError(MsgEnum.Account_ReEntry.getCode());
                result.setDesc(MsgEnum.Account_ReEntry.getMsg());
                SendMsgUtil.sendJsonMessage(response,result);
                return false;
            }else {
                return true;
            }
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("FirstInterceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//        System.out.println("FirstInterceptor afterCompletion");
    }
}
