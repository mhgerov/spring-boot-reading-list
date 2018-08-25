package org.mhgerov.readinglist;

import java.util.List;

public interface ReadingListGateway {
	
	List<Book> getReadingList(String reader);
	
	void addBook(Book book);
	
	void deleteBook(long id); 

}
