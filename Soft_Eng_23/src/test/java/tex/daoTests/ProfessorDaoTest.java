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
public class ProfessorDaoTest {
	@Autowired
	private ProfessorRepository proRepo;
	
	@Autowired
	private TestEntityManager entityManager;


	@Test
	public void testCreateProfessor() {
		Professor pro = new Professor();
		pro.setFullname("dimosaserd");
		pro.setSpecialty("nothingasdasd");
		
		Professor savedProfessor = proRepo.save(pro);
		
		Professor existPro = entityManager.find(Professor.class, savedProfessor.getId());
	
		assertThat(existPro.getFullname().equals(pro.getFullname()));
		assertThat(existPro.getSpecialty().equals(pro.getSpecialty()));
	}
	
	
}
