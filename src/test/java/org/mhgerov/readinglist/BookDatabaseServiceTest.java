package org.mhgerov.readinglist;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BookDatabaseServiceTest {

	@Autowired
	BookDatabaseService bookDatabaseService;

	@Test
	public void test() throws Exception {
		final Book book1 = new Book("john", "978-3-16-148410-0", "Dunkirk: The Novel", "Chris Nolan",
				"The book we deserve!");
		book1.setId((long) 1);
		final Book book2 = new Book("john", "978-3-16-148410-1", "Dunkirk 2: Return to Normandy", "Chris Nolan",
				"The book we don't need");
		book2.setId((long) 2);
		final List<Book> johnsBooks = new ArrayList<Book>();
		johnsBooks.add(book1);
		johnsBooks.add(book2);

		this.bookDatabaseService.saveBook(book1);
		this.bookDatabaseService.saveBook(book2);

		assertEquals(book1.getTitle(), this.bookDatabaseService.getListByReader("john").get(0).getTitle());
		assertEquals(book2.getIsbn(), this.bookDatabaseService.getListByReader("john").get(1).getIsbn());

	}
}
