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
public class ApplicationDaoTest {
	@Autowired
	private ApplicationRepository appRepo;
	
	@Autowired
	private StudentRepository stuRepo;
	
	@Autowired
	private TestEntityManager entityManager;


	@Test
	public void testCreateApplication() {
		Student stu=new Student("sdf",10,8.5,8);
		Application app = new Application();
		app.setStudent(stu);
		
		Application savedApplication = appRepo.save(app);
		Student savedStudent=stuRepo.save(stu);
		
		Application existAPP = entityManager.find(Application.class, savedApplication.getId());
	
		assertThat(existAPP.getStudent().equals(app.getStudent()));
		
	}
}
