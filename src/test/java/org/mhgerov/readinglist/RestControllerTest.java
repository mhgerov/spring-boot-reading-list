package org.mhgerov.readinglist;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(ReadingListApiController.class)
public class RestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookDatabaseService service;
	
	//private Book incomingBook = new Book("gerov","978-3-16-148410-0","Dunkirk: The Book","Chris Nolan","The book we deserve...");
	private MockHttpServletRequestBuilder incomingBookRequest = post("/api");
	
	@Before
	public void before() {
		incomingBookRequest.contentType(MediaType.APPLICATION_JSON);
	}
	
	@Test
	public void test() throws Exception{
		//Empty POST Request should return 400 error
		this.mockMvc.perform(incomingBookRequest
			).andExpect(
				status().is4xxClientError()
			);
	}
	
}
