package ru.bmstu.templebase.controller;

import com.concretepage.controller.ArticleInfo;
import com.concretepage.entity.Article;
import com.concretepage.service.IArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.bmstu.tamplebase.model.Temple;
import ru.bmstu.tamplebase.model.TempleFields;
import ru.bmstu.templebase.manager.BaseManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("temples")
@CrossOrigin(origins = {"http://localhost:4200"})
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
		Article article = new Article();
		try {
			templeservice.add(temple);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/temples/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//Updates article
	@PutMapping(produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Temple> update(@RequestBody Temple temple) {

		templeservice.update(temple);
		return new ResponseEntity<Temple>(temple, HttpStatus.OK);
	}
	
	//Deletes article by id
	@DeleteMapping(value= "{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		templeservice.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 