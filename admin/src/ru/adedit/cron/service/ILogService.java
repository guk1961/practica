package ru.adedit.cron.service;

import java.util.List;

import ru.adedit.cron.model.Log;

public interface ILogService extends IGenericService<Log> {

	public List<Log> getLog();
}
