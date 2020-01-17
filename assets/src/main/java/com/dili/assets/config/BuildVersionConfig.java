package com.dili.assets.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.dili.assets.versions.BuildVersion;

@Configuration
public class BuildVersionConfig {
	@Value("${build.version.number:}")
	private String buildVersionNumber;

	@Component
	@Profile({ "dev" })
	class DynamicBuildVersion implements BuildVersion {
		public String getVersion() {
			return String.valueOf(System.currentTimeMillis());
		}
	}

	@Component
	@Profile({ "!dev" })
	class FixedBuildVersion implements BuildVersion {
		public String getVersion() {
			if (buildVersionNumber.trim().equals("")) {
				buildVersionNumber = String.valueOf(System.currentTimeMillis());
			}
			return buildVersionNumber;
		}
	}

}
