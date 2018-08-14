package org.mhgerov.readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadingListRestController {
	
	private ReadingListRepository readingListRepository;
	
	@Autowired
	public ReadingListRestController(ReadingListRepository readingListRepository) {
		super();
		this.readingListRepository = readingListRepository;
	}

	@PostMapping("/api")
	public void addBook(@RequestBody Book book) {
		readingListRepository.save(book);
	}
	
}
