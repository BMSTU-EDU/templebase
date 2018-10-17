package ru.bmstu.templebase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bmstu.templebase.model.Temple;
import ru.bmstu.templebase.model.TempleFields;
import ru.bmstu.templebase.manager.BaseManager;
import ru.bmstu.templebase.repository.TempleRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TempleService implements BaseManager<Temple, TempleFields> {
	@Autowired
	private TempleRepository templeRepository;


	@Override
	public void add(Temple temple) {

	}

	@Override
	public void addAll(Collection<Temple> temples) {

	}

	@Override
	public Temple get(int id) {
		return templeRepository.findById(Long.valueOf(id)).get();
	}

	@Override
	public Collection<Temple> getAll() {
		List<Temple> list = new ArrayList<>();
		templeRepository.findAll().forEach(t -> list.add(t));
		return list;
	}

	@Override
	public void update(Temple temple) {
		templeRepository.save(temple);
	}

	@Override
	public void updateAll(Collection<Temple> temples) {
		templeRepository.saveAll(temples);
	}

	@Override
	public void delete(int id) {
		templeRepository.delete(get(id));
	}

	@Override
	public Collection<Temple> searchBy(TempleFields field, String value) {
		return null;
	}
}
