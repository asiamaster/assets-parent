package com.dili;

import org.springframework.boot.SpringApplication;

 class AssetsApplication_DEV {
	 public static void main(String[] args) {
	    	System.setProperty("org.jooq.no-logo", "true");
	    	System.setProperty("decorator.datasource.enabled", "true");
	    	System.setProperty("build.version.number", "0");
	    	SpringApplication springApplication=new SpringApplication(AssetsApplication.class);
	    	springApplication.setAdditionalProfiles("dev");
	    	 
	    	springApplication.run(args);
	    }

}
