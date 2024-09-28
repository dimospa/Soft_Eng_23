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
public class StudentDaoTest {

	@Autowired
	private StudentRepository stuRepo;
	
	@Autowired
	private TestEntityManager entityManager;


	@Test
	public void testCreateStudent() {
		Student stu = new Student();
		stu.setFullname("sdef");
		stu.setRemainingcourses(10);
		stu.setCurrentaveragegrade(5.6);
		stu.setYearofstudies(6);
		
		Student savedStudent = stuRepo.save(stu);
		
		Student existStu = entityManager.find(Student.class, savedStudent.getId());
	
		assertThat(existStu.getFullname().equals(stu.getFullname()));
		assertThat(existStu.getCurrentaveragegrade().equals(stu.getCurrentaveragegrade()));
		assertThat(existStu.getRemainingcourses().equals(stu.getRemainingcourses()));
		assertThat(existStu.getYearofstudies().equals(stu.getYearofstudies()));
	}
}
