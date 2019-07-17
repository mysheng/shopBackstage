package com.mysheng.office;

import com.github.pagehelper.PageHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@SpringBootApplication
@EnableTransactionManagement
public class OfficeApplication {



	public static void main(String[] args) {

		SpringApplication.run(OfficeApplication.class, args);
	}
	@Bean
    public PageHelper pageHelper(){
		PageHelper pageHelper = new PageHelper();
	    Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum","true");
	    properties.setProperty("rowBoundsWithCount","true");
		properties.setProperty("reasonable","false");
	    properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
	    pageHelper.setProperties(properties);
	   return pageHelper;
	}


}
