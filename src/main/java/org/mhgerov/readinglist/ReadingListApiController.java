package org.mhgerov.readinglist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadingListApiController {

	@Autowired
	private ReadingListGateway readingListGateway;

	// private final BookDatabaseService bookDatabaseService;

	@PostMapping("/api")
	@ResponseStatus(HttpStatus.CREATED)
	public void addBook(@RequestBody final Book book) {
		this.readingListGateway.addBook(book);
	}

	@GetMapping("/api")
	public List<Book> getBookList(@RequestParam final String reader) {
		// return bookDatabaseService.getListByReader(reader);
		return this.readingListGateway.getReadingList(reader);

	}

	@DeleteMapping("/api")
	public void deleteBook(@RequestParam final long id) {
		this.readingListGateway.deleteBook(id);
	}
}
