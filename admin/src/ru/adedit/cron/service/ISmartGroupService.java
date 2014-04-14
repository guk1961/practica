package ru.adedit.cron.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import ru.adedit.cron.model.SmartGroups;

public interface ISmartGroupService extends IGenericService<SmartGroups> {

    public List<SmartGroups> getGroups();
    public List<SmartGroups> getGroups(int first, int total, String name);
    public List <SmartGroups> getGroupsFromUser(int id);
    public SmartGroups getGroup(int id);
    public long getCountGroups(String name);
    public long getCount();
}
