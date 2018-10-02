package ru.bmstu.templebase.repository;

import com.concretepage.entity.Article;
import org.springframework.data.repository.CrudRepository;
import ru.bmstu.tamplebase.model.Temple;

import java.util.List;

public interface TempleRepository extends CrudRepository<Temple, Long>  {
    List<Temple> findByName(String name);

}
