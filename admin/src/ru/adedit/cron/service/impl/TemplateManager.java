package ru.adedit.cron.service.impl;

import java.io.FileInputStream;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import ru.adedit.cron.Cron;


public class TemplateManager {
    
//	private VelocityContext context = new VelocityContext();
    private VelocityEngine engine = new VelocityEngine();
	private Properties props = new Properties();
//	private Template tmpl;
	
    public void init() {
        Cron cron = Cron.getInstance();
        String homeDir = cron.getHomeDir();
        String encoding = cron.getConfiguration().getFileEncoding();
        try {
            String tml = "{home_dir}";
            Properties properties = new Properties();
            properties.load(new FileInputStream(homeDir+"\\conf\\velocity.properties"));
            String value = properties.getProperty("file.resource.loader.path");
            value = value.substring(tml.length(), value.length());
            properties.put("file.resource.loader.path", homeDir+value);
            properties.setProperty(Velocity.INPUT_ENCODING, encoding);
            properties.setProperty(Velocity.OUTPUT_ENCODING, encoding);
            System.out.println("-------РњРµРЅРµРґР¶РµСЂ С€Р°Р±Р»РѕРЅРѕРІ>>>>>>>>>>>>"+homeDir+value+"<<<<<<<<<<<<<---------");
//            System.out.println("-------РњРµРЅРµРґР¶РµСЂ С€Р°Р±Р»РѕРЅРѕРІ>>>>>>>>>>>>"+homeDir+"<<<<<<<<<<<<<---------");
            engine = new VelocityEngine(properties);
            engine.init(properties);
            
        } catch (Exception err) {
            throw new RuntimeException(err);
        }

   }
    public String merge(String templateName, VelocityContext context) {
        try {
            StringWriter sw = new StringWriter();
            engine.getTemplate(templateName).merge(context, sw);
//            engine.mergeTemplate(templateName, context, sw); 
            return sw.getBuffer().toString();
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
    }
    public void destroy() {
        engine = null;
    }
}
