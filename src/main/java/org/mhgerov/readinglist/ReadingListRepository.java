package org.mhgerov.readinglist;

import java.util.List;

import org.mhgerov.readinglist.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
	  List<Book> findByReader(String reader);
}
