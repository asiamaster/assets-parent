package com.dili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.dili.ss.dto.DTOScan;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * 由MyBatis Generator工具自动生成
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.dili.assets.mapper", "com.dili.ss"})
@ComponentScan(basePackages={"com.dili.ss","com.dili.assets"})
@DTOScan(value={"com.dili.ss", "com.dili.assets.domain"})
@EnableDiscoveryClient
@EnableFeignClients
public class AssetsApplication extends SpringBootServletInitializer {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
    	System.setProperty("org.jooq.no-logo", "true");
    	SpringApplication springApplication=new SpringApplication(AssetsApplication.class);
    	springApplication.run(args);
    }


}
