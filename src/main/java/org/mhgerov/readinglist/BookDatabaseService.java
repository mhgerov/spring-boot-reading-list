package org.mhgerov.readinglist;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookDatabaseService {

	private ReadingListRepository readingListRepository;
	
	public BookDatabaseService (ReadingListRepository readingListRepository) {
		this.readingListRepository = readingListRepository;
	}
	
	void saveBook(Book book) {
		readingListRepository.save(book);
	}
	
	List<Book> getListByReader(String reader) {
		return readingListRepository.findByReader(reader);
	}
	
	void deleteBook(Long id) {
		readingListRepository.deleteById(id);
	}
	
}
