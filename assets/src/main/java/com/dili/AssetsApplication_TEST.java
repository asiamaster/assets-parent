package com.dili;

import org.springframework.boot.SpringApplication;

 class AssetsApplication_TEST {
	 public static void main(String[] args) {
	    	System.setProperty("org.jooq.no-logo", "true");
	    	SpringApplication springApplication=new SpringApplication(AssetsApplication.class);
	    	springApplication.setAdditionalProfiles("test");
	    	springApplication.run(args);
	    }
}
