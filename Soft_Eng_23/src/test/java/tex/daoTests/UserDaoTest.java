package tex.daoTests;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import tex.model.*;
import tex.dao.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserDaoTest {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestEntityManager entityManager;


	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUsername("tes");
		user.setPassword("123456789");
		
		User savedUser = userRepository.save(user);
		
		User existUser = entityManager.find(User.class, savedUser.getId());
	
		assertThat(existUser.getUsername().equals(user.getUsername()));
		assertThat(existUser.getPassword().equals(user.getPassword()));
	}
	
	@Test
	public void testFindUsername() {
		
		String username = "tes";
		
		User user = userRepository.findByUsername(username);
		
		assertThat(user).isNotNull();
	}

	

}
