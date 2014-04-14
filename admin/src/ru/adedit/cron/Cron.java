package ru.adedit.cron;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.adedit.cron.conf.Configuration;
import ru.adedit.cron.service.impl.SmartChannelServiceImpl;
import ru.adedit.cron.service.impl.SmartIssueServiceImpl;
import ru.adedit.cron.service.impl.SmartPublicationServiceImpl;
import ru.adedit.cron.service.impl.TemplateManager;

public class Cron {
    
	private static Cron instance;

//    @PersistenceUnit(unitName="cron")
    private EntityManager entityManager;
    private Configuration configuration;
    private String homeDir;
    private String fileProps="/conf/cron.properties";
    private SmartPublicationServiceImpl smartPublicationService;
    private SmartIssueServiceImpl smartIssueService;
    private SmartChannelServiceImpl smartChannelService;
    private TemplateManager templateManager;
    private EntityManagerFactory emf;
    
    
    public static Cron getInstance() {
    	if (instance==null) instance = new Cron(); 
    		
       return instance;
    }
    

    public void  init(String homeDir) {
        this.homeDir = homeDir;
        System.setProperty("cron.home", homeDir);
        System.out.println("домашняя директория => "+homeDir);

        configuration = new Configuration(homeDir+fileProps);
        configuration.load();
        Logger logger = LoggerFactory.getLogger(Cron.class);
        logger.info(configuration.toString());

        emf = Persistence.createEntityManagerFactory("cron");
        entityManager = emf.createEntityManager();
        smartPublicationService	=	new SmartPublicationServiceImpl();
        smartIssueService	=	new SmartIssueServiceImpl();
        smartChannelService	=	new SmartChannelServiceImpl();
        templateManager     = new TemplateManager();
        
        templateManager.init();
        smartPublicationService.init();
        smartIssueService.init();
        smartChannelService.init();
    }

    
    public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public SmartChannelServiceImpl getSmartChannelService() {
		return smartChannelService;
	}

	public void setSmartChannelService(SmartChannelServiceImpl smartChannelService) {
		this.smartChannelService = smartChannelService;
	}

	public SmartIssueServiceImpl getSmartIssueService() {
		return smartIssueService;
	}

	public void setSmartIssueService(SmartIssueServiceImpl smartIssueService) {
		this.smartIssueService = smartIssueService;
	}

	public String getHomeDir() {
        return homeDir;
    }
    public Configuration getConfiguration() {
        return configuration;
    }
    public EntityManager getEntityManager() {
        return entityManager;
    }


    public TemplateManager getTemplateManager() {
        return templateManager;
    }



    public SmartPublicationServiceImpl getSmartPublicationService() {
		return smartPublicationService;
	}

	public void setSmartPublicationService(
			SmartPublicationServiceImpl smartPublicationService) {
		this.smartPublicationService = smartPublicationService;
	}

	public void setTemplateManager(TemplateManager templateManager) {
		this.templateManager = templateManager;
	}

	public void destroy() {
        instance = null;
        configuration = null;
        entityManager.close();
        templateManager.destroy();
        smartPublicationService.destroy();
        smartIssueService.destroy();
        smartChannelService.destroy();
    }



}