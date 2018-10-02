package ru.bmstu.test;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import ru.bmstu.tamplebase.model.Temple;
import ru.bmstu.tamplebase.model.TempleFields;
import ru.bmstu.templebase.manager.BaseManager;
import ru.bmstu.test.templebase.manager.TestBaseManager;

import java.util.List;

public class TempleTest {
    private BaseManager<Temple, TempleFields> baseManager = new TestBaseManager();
    private Temple current;

    @Дано("^Объекты в базе$")
    public void объекты_в_базе(List<Temple> temples) throws Throwable {
        baseManager.addAll(temples);
        Assert.assertFalse(baseManager.getAll().isEmpty());

    }

    @Когда("^пользователь вводит (\\d+) в консоль$")
    public void пользователь_вводит_в_консоль(int arg1) throws Throwable {
        current = baseManager.get(arg1);
        Assert.assertNotNull(current);
    }

    @Тогда("^в консоль выводится \"([^\"]*)\"$")
    public void в_консоль_выводится(String arg1) throws Throwable {
        Assert.assertEquals(arg1, current.getName());
    }

}
