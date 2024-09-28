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
public class SubjectDaoTest {
	@Autowired
	private SubjectRepository subRepo;
	
	@Autowired
	private ProfessorRepository proRepo;
	
	@Autowired
	private TestEntityManager entityManager;


	@Test
	public void testCreateSubject() {
		Professor pro = new Professor();
		pro.setFullname("nathanail");
		pro.setSpecialty("ppttp");
		
		Subject sub=new Subject();
		sub.setTitle("sdf");
		sub.setDetails("aegbdfh");
		sub.setProfessor(pro);
		
		Subject savedSubject = subRepo.save(sub);
		Professor savedProfessor=proRepo.save(pro);
		
		Subject existSub = entityManager.find(Subject.class, savedSubject.getId());
	
		assertThat(existSub.getTitle().equals(sub.getTitle()));
		assertThat(existSub.getDetails().equals(sub.getDetails()));
		assertThat(existSub.getProfessor().equals(sub.getProfessor()));
	}
}
