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
public class ReadingListApiController {
	
	@Autowired
	private ReadingListGateway readingListGateway;
	
	//private final BookDatabaseService bookDatabaseService;
	


	@PostMapping("/api")
	public void addBook(@RequestBody Book book) {
		readingListGateway.addBook(book);
	}
	
	
	@GetMapping("/api")
	public List<Book> getBookList(@RequestParam String reader) {
		//return bookDatabaseService.getListByReader(reader);
		return readingListGateway.getReadingList(reader);
	
	}
	
	@DeleteMapping("/api")
	public void deleteBook(@RequestParam long id) {
		readingListGateway.deleteBook(id);
	}
}
