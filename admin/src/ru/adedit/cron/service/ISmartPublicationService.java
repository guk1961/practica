package ru.adedit.cron.service;

import java.util.Collection;
import ru.adedit.cron.model.SmartPublication;

public interface ISmartPublicationService  extends IGenericService<SmartPublication>{

	public Collection<SmartPublication> getPublications();

}
