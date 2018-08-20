package org.mhgerov.readinglist;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private ReadingListController controller1;
	
	@Autowired
	private ReadingListApiController controller2;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller1).isNotNull();
		assertThat(controller2).isNotNull();
	}
}
