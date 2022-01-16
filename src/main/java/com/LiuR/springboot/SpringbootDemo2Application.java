package com.LiuR.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

@SpringBootApplication
public class SpringbootDemo2Application {

    
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootDemo2Application.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        //打印所有的请求地址
        RequestMappingHandlerMapping bean = run.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = bean.getHandlerMethods();
        System.out.println(handlerMethods.size());
        List<String> urls = new ArrayList<>();
        for (RequestMappingInfo info : handlerMethods.keySet()){
            Set<String> patterns = info.getPatternValues();

            for (String url : patterns){
                urls.add(url);
            }
        }
        for (String str : urls){
            System.out.println(str);
        }

    }

}
