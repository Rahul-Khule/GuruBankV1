package com.guru99bank.utilities;
//2. to read the values from properties file we create read config class

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	//create propeties object
	Properties pro;
	
	//create a constructor for the read config
	public ReadConfig() {
		File src = new File("./configuration/config.properties");
		 
		 try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	//add diffrent methods tp read values
	public String getAppURl() {
		String url = pro.getProperty("baseurl");
		return url;
	}
	public String getUsername() {
		String uname = pro.getProperty("uername");
		return uname;
	}
	public String getPassword() {
		String pwd = pro.getProperty("password");
		return pwd;
	}
	public String getChromepath() {
		String cpath = pro.getProperty("chromepath");
		return cpath;
	}
	public String getEdgepath() {
		String epath = pro.getProperty("edgepath");
		return epath;
	}
	
}
