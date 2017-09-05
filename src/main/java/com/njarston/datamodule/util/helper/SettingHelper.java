package com.njarston.datamodule.util.helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class SettingHelper{

	private static SettingHelper settingHelper = new SettingHelper();
	private Properties p = new Properties();

	private SettingHelper() {
		try {
			//InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("setting.properties");
			p.load(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("setting.properties"), "UTF-8"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public String _getSetting(String set) {
		return p.getProperty(set);
	}

	public static String getSetting(String set) {
		return settingHelper._getSetting(set);
	}

	public String getConfig(String name){
		return getSetting(name);
	}
}
