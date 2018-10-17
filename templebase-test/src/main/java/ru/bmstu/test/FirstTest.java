package ru.bmstu.test;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import ru.bmstu.templebase.model.Temple;

import java.util.List;

public class FirstTest {
    private List<Temple> temples = null;
    private Temple current = null;

    @Дано("^Объекты$")
    public void объекты(List<Temple> temples) throws Throwable {
        this.temples = temples;
        Assert.assertNotNull(this.temples);
    }

    @Когда("^пользователь вводит (\\d+) в консоль$")
    public void пользователь_вводит_в_консоль(int id) throws Throwable {
        for(Temple t: temples) {
            if (t.getId() == id) {
                current = t;
            }
        }
        Assert.assertNotNull(current);
    }

    @Тогда("^в консоль выводится \"(.*?)\"$")
    public void в_консоль_выводится(String arg1) throws Throwable {
       Assert.assertEquals(arg1, current.getName());
    }

}
