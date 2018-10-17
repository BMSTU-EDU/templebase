package ru.bmstu.templebase.repository;

import org.springframework.data.repository.CrudRepository;
import ru.bmstu.templebase.model.Temple;

import java.util.List;

public interface TempleRepository extends CrudRepository<Temple, Long>  {
    List<Temple> findByName(String name);

}
