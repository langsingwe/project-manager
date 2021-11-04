package org.example.filter;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author weilc
 * @version 1.0
 * @description xss过滤包装类
 * @className XssHttpServletRequestWrapper
 * @date 2021.10.13
 */
@Slf4j
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getHeader(String name) {
        String header = super.getHeader(name);
        if (StrUtil.isEmpty(header)) {
            return header;
        }
        return Jsoup.clean(super.getHeader(name), Whitelist.relaxed());
    }

    @Override
    public String getParameter(String name) {
        String parameter = super.getParameter(name);
        if (StrUtil.isEmpty(parameter)) {
            return parameter;
        }
        return Jsoup.clean(super.getParameter(name), Whitelist.relaxed());
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        int length = values.length;
        if (values == null || length == 0) {
            return values;
        }
        String[] escapseValues = new String[length];
        for (int i = 0; i < length; i++) {
            //过滤一切可能的xss攻击字符串
            escapseValues[i] = Jsoup.clean(values[i], Whitelist.relaxed()).trim();
            if(!StrUtil.equals(escapseValues[i],values[i])){
                log.debug("xss字符串过滤前："+values[i]+"\r\n"+"过滤后："+escapseValues[i]);
            }
        }
        return escapseValues;
    }
}
