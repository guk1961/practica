package ru.adedit.cron.service;

import java.util.List;

import ru.adedit.cron.model.SmartChannel;
import ru.adedit.cron.model.SmartPublication;

public interface ISmartChannelService  extends IGenericService<SmartChannel>{

	public SmartChannel getChannel(int publicationId);

	public SmartChannel getChannel(SmartPublication pub);
	
	public List<SmartChannel> getChannels(int code);
}
