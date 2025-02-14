package com.anno.example.annotation.demo.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotationDemo {

	@Value("Default name")
	private String defaultName;

	// Reading values from application.properties file using @Value("${key name}")
	// In application.properties, key=value pair : mail.host=gmail.com
	// Key value pairs from application.properties file
	@Value("${mail.host}")
	private String host;

	@Value("${mail.password}")
	private String password;

	// ENV Variables
	@Value("${java.home}")
	private String javaHome;

	// ENV Variables
//	@Value("${HOME}")
//	private String homeDir;

	public String getDefaultName() {
		return defaultName;
	}

	public String getHost() {
		return host;
	}

	public String getPassword() {
		return password;
	}

	public String getJavaHome() {
		return javaHome;
	}

//	public String getHomeDir() {
//		return homeDir;
//	}

}
