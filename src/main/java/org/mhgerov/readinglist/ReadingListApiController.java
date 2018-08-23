package org.mhgerov.readinglist;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadingListApiController {
	
	private final BookDatabaseService bookDatabaseService;
	
	public ReadingListApiController (BookDatabaseService bookDatabaseService) {
		this.bookDatabaseService = bookDatabaseService;
	}

	@PostMapping("/api")
	public void addBook(@RequestBody Book book) {
		bookDatabaseService.saveBook(book);
	}
	
	@GetMapping("/api")
	public List<Book> getBookList(@RequestParam String reader) {
		return bookDatabaseService.getListByReader(reader);
	}
	
	@DeleteMapping("/api")
	public void deleteBook(@RequestParam Long id) {
		bookDatabaseService.deleteBook(id);;
	}
}
