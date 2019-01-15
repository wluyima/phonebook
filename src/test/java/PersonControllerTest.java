
/*
 * Add Copyright
 */

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import com.phonebook.Bootstrap;
import com.phonebook.model.Person;
import com.phonebook.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Bootstrap.class)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class PersonControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PersonService service;
	
	private static final String SUB_PATH = "/api/person";
	
	@Test
	public void getAll_shouldGetAllPersons() throws Exception {
		Person p = new Person();
		p.setFirstName("John");
		p.setLastName("Doe");
		p.setPhoneNumber("317-456-1233");
		service.save(p);
		
		RequestBuilder request = get(SUB_PATH);
		ResultActions resultActions = mockMvc.perform(request);
		resultActions.andExpect(status().isOk());
		resultActions.andExpect(jsonPath("length()", equalTo(0)));
		
	}
	
}
