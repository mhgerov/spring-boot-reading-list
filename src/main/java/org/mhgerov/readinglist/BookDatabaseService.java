package org.mhgerov.readinglist;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookDatabaseService {

	private ReadingListRepository readingListRepository;
	
	public BookDatabaseService (ReadingListRepository readingListRepository) {
		this.readingListRepository = readingListRepository;
	}
	
	public void saveBook(Book book) {
		readingListRepository.save(book);
	}
	
	public List<Book> getListByReader(String reader) {
		return readingListRepository.findByReader(reader);
	}
	
	public void deleteBook(long id) {
		readingListRepository.deleteById(id);
	}
	
}
