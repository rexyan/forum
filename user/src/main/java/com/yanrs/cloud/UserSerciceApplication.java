package com.yanrs.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@MapperScan("com.yanrs.cloud.user.mapper")
@EnableTransactionManagement
// 开启服务注册发现
@EnableDiscoveryClient
@SpringBootApplication
public class UserSerciceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSerciceApplication.class, args);
	}

}
