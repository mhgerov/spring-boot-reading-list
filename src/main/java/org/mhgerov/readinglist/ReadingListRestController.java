package org.mhgerov.readinglist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/api")
	public List<Book> getBookList(@RequestParam String reader) {
		return readingListRepository.findByReader(reader);
	}
	
	@DeleteMapping("/api")
	public void deleteBook(@RequestParam Long id) {
		readingListRepository.deleteById(id);
	}
}
