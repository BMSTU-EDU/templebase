package ru.bmstu.templebase.model;

import org.junit.Assert;
import org.junit.Test;

public class ModelTest {
    @Test
    public void testModelCreate() {
        Temple temple = new Temple();
        temple.setId(1);
        temple.setName("Name");

        Assert.assertEquals("Name", temple.getName());

    }
}
