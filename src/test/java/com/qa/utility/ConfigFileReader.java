package com.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private static Properties prop;

	public static Properties getConfig(String configPath) {
		prop = new Properties();
		try {
			FileInputStream iOS = new FileInputStream(
					System.getProperty("user.dir") + configPath);
			prop.load(iOS);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
