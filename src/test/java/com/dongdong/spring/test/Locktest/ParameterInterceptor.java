package com.dongdong.spring.test.Locktest;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Date: 2019/11/27  15:53
 * @Author: dongdong
 */
public class ParameterInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String device=request.getParameter("device");
        BaseSigntureRequest baseSigntureRequest=new BaseSigntureRequest();
        baseSigntureRequest.setDevice(device);
        ThreadLocalCache.baseSigntureRequestThreadLocal.set(baseSigntureRequest);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalCache.baseSigntureRequestThreadLocal.remove();
    }
}
