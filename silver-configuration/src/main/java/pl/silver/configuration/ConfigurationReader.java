package pl.silver.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import pl.silver.configuration.exceptions.ConfigurationReadException;

public enum ConfigurationReader {
	INSTANCE;
	private static final String CONFIGURATION_NAME = "config.properties";
	private Properties properties;

	private ConfigurationReader() {
		reload();
	}

	public void reload() {
		getConfig();
	}

	private void getConfig() {
		try {
			getExternalProperties();
		} catch (ConfigurationReadException e) {
			try {
				getInternalProperties();
			} catch (ConfigurationReadException e1) {
				System.err.println("Cannot find any configuration files");
			}
		}
	}

	private void getExternalProperties() throws ConfigurationReadException {
		File configFile = null;
		String envConfigPath = System.getenv("CONFIG_FILE");
		if (envConfigPath != null) {
			configFile = new File(envConfigPath);
		} else {
			File jarFolder = null;
			try {
				jarFolder = new File(ConfigurationReader.class.getProtectionDomain().getCodeSource().getLocation()
						.toURI().getPath());
			} catch (Exception e) {
				throw new ConfigurationReadException(e);
			}
			configFile = new File(jarFolder.getParentFile(), CONFIGURATION_NAME);
		}
		properties = new Properties();
		try {
			properties.load(new FileInputStream(configFile));
		} catch (Exception e) {
			throw new ConfigurationReadException(e);
		}
	}

	private void getInternalProperties() throws ConfigurationReadException {
		properties = new Properties();
		try {
			// load a properties file from class path, inside static method
			properties.load(ConfigurationReader.class.getClassLoader().getResourceAsStream(CONFIGURATION_NAME));
		} catch (IOException ex) {
			try {
				properties.load(ConfigurationReader.class.getClassLoader()
						.getResourceAsStream("resource/" + CONFIGURATION_NAME));
			} catch (IOException e) {
				throw new ConfigurationReadException(e);
			}
		}
	}

	public String getString(String key) {
		return properties.getProperty(key);
	}

	public String getString(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public int getInt(String key) {
		String propertiesValue = properties.getProperty(key);
		return Integer.parseInt(propertiesValue);
	}

	public int getInt(String key, int defaultValue) {
		String propertiesValue = properties.getProperty(key, Integer.toString(defaultValue));
		return Integer.parseInt(propertiesValue);
	}

	public float getFloat(String key) {
		String propertiesValue = properties.getProperty(key);
		return Float.parseFloat(propertiesValue);
	}

	public float getFloat(String key, float defaultValue) {
		String propertiesValue = properties.getProperty(key, Float.toString(defaultValue));
		return Float.parseFloat(propertiesValue);
	}

	public Boolean isTrue(String key) {
		return Boolean.parseBoolean(properties.getProperty(key));
	}

	public Boolean isFalse(String key) {
		return !Boolean.parseBoolean(properties.getProperty(key));
	}
}
