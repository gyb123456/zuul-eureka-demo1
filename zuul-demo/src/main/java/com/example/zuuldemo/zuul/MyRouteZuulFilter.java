package com.example.zuuldemo.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;

/**
 * zuul的过滤器，filterType设为ROUTE_TYPE了，可以更改转发的url
 * 20181025
 */
@Component
public class MyRouteZuulFilter extends ZuulFilter{
    private static Logger log = LoggerFactory.getLogger(MyRouteZuulFilter.class);
    @Override
    public boolean shouldFilter() {
//        final String serviceId = (String) RequestContext.getCurrentContext().get("proxy");
//        return "demo".equals(serviceId);
        return true;
    }

    /**
     * 判断header里是否有accessToken，有则转发，无则返回401
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s --- %s", request.getMethod(), request.getRequestURL().toString()));

        //修改路由的url后缀，注意与yml配置文件的stripPrefix配合使用
//        Object originalRequestPath = ctx.get(FilterConstants.REQUEST_URI_KEY);
//        System.out.println("路由："+originalRequestPath);
//        ctx.put(FilterConstants.REQUEST_URI_KEY, "/aaa");

        try {
            //修改路由的Host(ip+port)，注意与yml配置文件的stripPrefix配合使用
            System.out.println("URL:"+ctx.getRouteHost());
            ctx.setRouteHost(new URL("http://localhost:1111/test"));
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * filterType：返回一个字符串代表过滤器的类型，数字越低等级越高
     * pre: 在路由转发之前起作用,主要是用来给 route 型过滤器设置所需信息的,如添加参数等
     * routing: 是用来发送请求给其他的服务用的，在这里它的大部分工作是转换请求和响应数据给前台客户端，修改url必须写在这里！！！
     * post: 在把结果返回给浏览器时起作用，Post 类型的 filters 就是对响应体的操作
     * error: 在整个路由阶段，出现异常时起作用
     */
    @Override
    public String filterType() {
        return  FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SIMPLE_HOST_ROUTING_FILTER_ORDER -1;
    }
}
