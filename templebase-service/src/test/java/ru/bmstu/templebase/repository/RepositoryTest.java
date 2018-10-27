package ru.bmstu.templebase.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bmstu.templebase.model.Temple;
import ru.bmstu.templebase.repository.TempleRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TempleRepository repository;

    @Test
    public void testExample() throws Exception {
        Temple t = new Temple();
        t.setId(4);
        t.setName("Temple4");
        this.entityManager.persistAndFlush(t);
        Temple t2 = this.repository.findByName("Temple4").get(0);
        Assert.assertEquals(t.getId(), t2.getId());
    }
}
