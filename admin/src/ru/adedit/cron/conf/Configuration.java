package ru.adedit.cron.conf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private String confFileName;

    private String fileEncoding = "UTF-8";
    private String encryptionKey = "lfrjnf";
    private String fileStore = "e:\\Commons\\filestore\\";
    private String appContext = "/cron";
    private int maxConnections = 90;

    
    public String getAppContext() {
		return appContext;
	}


	public void setAppContext(String appContext) {
		this.appContext = appContext;
	}


	public Configuration(String confFileName) {
        this.confFileName = confFileName;
    }

    
    public String getConfFileName() {
		return confFileName;
	}


	public void setConfFileName(String confFileName) {
		this.confFileName = confFileName;
	}


	public String getFileEncoding() {
		return fileEncoding;
	}


	public void setFileEncoding(String fileEncoding) {
		this.fileEncoding = fileEncoding;
	}


	public String getEncryptionKey() {
		return encryptionKey;
	}


	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}


	public String getFileStore() {
		return fileStore;
	}


	public void setFileStore(String fileStore) {
		this.fileStore = fileStore;
	}


	public int getMaxConnections() {
		return maxConnections;
	}


	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}


	public void load() {
        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream(confFileName);
            properties.load(fis);
            fis.close();

            fileStore     = properties.getProperty("file.fileStore", fileStore);
            fileEncoding  = properties.getProperty("file.Encoding", fileEncoding);
            encryptionKey = properties.getProperty("encryption.Key", encryptionKey);
            appContext    = properties.getProperty("app.context", appContext);
            try {
                maxConnections = Integer.parseInt(properties.getProperty("max.Connections", String.valueOf(maxConnections)));
            } catch (NumberFormatException err) {
                throw new RuntimeException("Parameter \"maxConnections\" has a wrong format");
            }
        } catch (FileNotFoundException err) {
            throw new RuntimeException(err);
        } catch (IOException err) {
            throw new RuntimeException(err);
        }
    }
    public String toString() {
        return "Configuration: " + confFileName + "\n" +
                "File encoding: " + getFileEncoding() + "\n" +
                "Encryption key: " + getEncryptionKey() + "\n" +
                "Max connections: " + getMaxConnections() + "\n"+
                "Хранилище: " + getFileStore() + "\n";
    }

}
