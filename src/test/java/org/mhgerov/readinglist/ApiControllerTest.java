package org.mhgerov.readinglist;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;

import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;




@RunWith(SpringRunner.class)
@WebMvcTest(ReadingListApiController.class)
public class ApiControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookDatabaseService service;	

	@Test
	public void getListProperRequest() throws Exception{
		
		//Seed books
		Book book1 = new Book("john","978-3-16-148410-0","Dunkirk: The Novel","Chris Nolan","The book we deserve!");
		book1.setId((long) 1);
		Book book2 = new Book("john","978-3-16-148410-1","Dunkirk 2: Return to Normandy","Chris Nolan","The book we don't need");
		book2.setId((long)2);
		List<Book> johnsBooks = new ArrayList<Book>();
		johnsBooks.add(book1);
		johnsBooks.add(book2);
		when(service.getListByReader("john")).thenReturn(johnsBooks);
		
		JSONArray expected = new JSONArray(readJSON("src/test/java/johnsBooks.json"));
		
		MockHttpServletResponse response = this.mockMvc.perform(get("/api?reader=john")).andReturn().getResponse();
		JSONArray returned = new JSONArray(response.getContentAsString());
		
		JSONAssert.assertEquals(expected,returned,false);
		
	}
	
	//Helper method to return String from JSON file
	private String readJSON(String fileName) {
		Path currentPath = Paths.get(System.getProperty("user.dir"));
		String absFileName = Paths.get(currentPath.toString(), fileName).toString();
		String result = "";
	    try {
	        BufferedReader br = new BufferedReader(new FileReader(absFileName));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        result = sb.toString();
	        br.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
}
