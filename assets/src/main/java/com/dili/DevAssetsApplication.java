package com.dili;

import org.springframework.boot.SpringApplication;

 class DevAssetsApplication {
	 public static void main(String[] args) {
	    	System.setProperty("org.jooq.no-logo", "true");
	    	SpringApplication springApplication=new SpringApplication(AssetsApplication.class);
	    	springApplication.setAdditionalProfiles("dev");
	    	springApplication.run(args);
	    }

}
