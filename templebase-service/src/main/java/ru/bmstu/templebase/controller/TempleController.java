package ru.bmstu.templebase.controller;

import com.concretepage.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.bmstu.templebase.model.Temple;
import ru.bmstu.templebase.model.TempleFields;
import ru.bmstu.templebase.manager.BaseManager;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("temples")
@CrossOrigin(maxAge = 3600)
public class TempleController {
	@Autowired
	private BaseManager<Temple, TempleFields> templeservice;

	
	@GetMapping(value= "{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Temple> getTempleById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Temple>(templeservice.get(id), HttpStatus.OK);
	}

	@GetMapping( produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Temple>> getTemples() {

		return new ResponseEntity<List<Temple>>(new ArrayList(templeservice.getAll()), HttpStatus.OK);
	}


	@PostMapping( produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> addTemple(@RequestBody Temple temple, UriComponentsBuilder builder) {
		try {
			System.out.println(temple.getName());
			templeservice.add(temple);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/temples/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
	@PutMapping(produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Temple> update(@RequestBody Temple temple) {

		templeservice.update(temple);
		return new ResponseEntity<Temple>(temple, HttpStatus.OK);
	}

	
	@DeleteMapping(value= "{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		templeservice.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 
