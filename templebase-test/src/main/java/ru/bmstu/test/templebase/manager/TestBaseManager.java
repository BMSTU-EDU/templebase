package ru.bmstu.test.templebase.manager;

import junit.framework.Test;
import ru.bmstu.tamplebase.model.Temple;
import ru.bmstu.tamplebase.model.TempleFields;
import ru.bmstu.templebase.manager.BaseManager;

import java.util.*;

public class TestBaseManager implements BaseManager<Temple, TempleFields> {
    private Map<Integer, Temple> templeMap = new HashMap<>();

    @Override
    public void add(Temple temple) {
        templeMap.put(temple.getId(), temple);
    }

    @Override
    public void addAll(Collection<Temple> temples) {
        for (Temple t:temples) {
            add(t);
        }
    }

    @Override
    public Temple get(int id) {
        return templeMap.get(id);
    }


    @Override
    public Collection<Temple> getAll() {
        return templeMap.values();
    }

    @Override
    public void update(Temple temple) {
        templeMap.put(temple.getId(), temple);
    }

    @Override
    public void updateAll(Collection<Temple> temples) {
        for (Temple t:temples) {
            update(t);
        }
    }

    @Override
    public void delete(int id) {
        templeMap.remove(id);
    }

    @Override
    public Collection<Temple> searchBy(TempleFields field, String value) {
        switch (field) {
            case ID: return Collections.singletonList(get(Integer.valueOf(value)));
            case NAME: return searchByName(value);
        }
        return null;
    }

    private Collection<Temple> searchByName(String name) {
        Set<Temple> templeSet = new HashSet<>();
        for (Temple t:templeMap.values()) {
            if(t.getName().equals(name)) {
                templeSet.add(t);
            }
        }
        return templeSet;
    }

}
