package org.example.util.http;

import cn.hutool.core.convert.Convert;
import org.example.entity.vo.UserInfoVo;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author : weilc
 * @version : 1.0
 * @date : 2020/11/30 23:54
 * @description : Servlet 工具类
 * @email : weilc@si-tech.com.cn
 */
public class ServletUtils {

    /**
     * 获取String参数
     */
    public static String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    /**
     * 获取String参数
     */
    public static String getParameter(String name, String defaultValue) {
        return Convert.toStr(getRequest().getParameter(name), defaultValue);
    }

    /**
     * 获取Integer参数
     */
    public static Integer getParameterToInt(String name) {
        return Convert.toInt(getRequest().getParameter(name));
    }

    /**
     * 获取Integer参数
     */
    public static Integer getParameterToInt(String name, Integer defaultValue) {
        return Convert.toInt(getRequest().getParameter(name), defaultValue);
    }

    /**
     * 获取request
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /**
     * 获取response
     */
    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    /**
     * 获取session
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

//    /**
//     * 获取登录用户信息
//     * @return
//     */
//    public static UserInfoVo getSessionUserInfo() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpSession session = attributes.getRequest().getSession();
//        UserInfoVo userInfoVo =  (UserInfoVo) session.getAttribute("user_session");
//        return userInfoVo;
//    }
//
//    /**
//     * 保存登录用户信息
//     * @param userInfoVo
//     */
//    public static void setSessionUserInfo(UserInfoVo userInfoVo) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpSession session = attributes.getRequest().getSession();
//        session.setAttribute("user_session", userInfoVo);
//    }
}
