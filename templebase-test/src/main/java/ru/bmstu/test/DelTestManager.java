package ru.bmstu.test;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import ru.bmstu.tamplebase.model.Temple;
import ru.bmstu.tamplebase.model.TempleFields;
import ru.bmstu.templebase.manager.BaseManager;
import ru.bmstu.templemanager.database.DatabaseTempleManager;
import ru.bmstu.test.templebase.manager.TestBaseManager;

import java.util.List;

public class DatabaseTest {
    private BaseManager<Temple, TempleFields> baseManager = new DatabaseTempleManager();
    private Temple current;

    @Дано("^Объекты в базе данных$")
    public void объекты_в_базе_данных(List<Temple> temples) throws Throwable {
        baseManager.addAll(temples);
        Assert.assertFalse(baseManager.getAll().isEmpty());
    }

    @Когда("^передаем (\\d+) в менеджер$")
    public void передаем_в_менеджер(int arg1) throws Throwable {
        current = baseManager.delete(arg1);
        Assert.assertNotNull(current);
    }

     @Тогда("^менеджер возвращает \"([^\"]*)\"$")
    public void менеджер_возвращает(String arg1) throws Throwable {
        Assert.assertEquals(arg1, current.getName());
    }
    
    
}
