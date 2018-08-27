package org.mhgerov.readinglist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDatabaseService {

	@Autowired
	private final ReadingListRepository readingListRepository;

	public BookDatabaseService(final ReadingListRepository readingListRepository) {
		this.readingListRepository = readingListRepository;
	}

	public long saveBook(final Book book) {
		final Book saved = this.readingListRepository.save(book);
		return saved.getId();
	}

	public List<Book> getListByReader(final String reader) {
		return this.readingListRepository.findByReader(reader);
	}

	public void deleteBook(final long id) {
		this.readingListRepository.deleteById(id);
	}

}
