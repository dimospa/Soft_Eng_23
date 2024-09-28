package tex.serviceTests;

import tex.dao.ProfessorRepository;
import tex.dao.SubjectRepository;
import tex.model.Professor;
import tex.model.Subject;
import tex.service.ProfessorService;
import tex.service.ProfessorServicelmpl;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProfessorServiceTest {
	
	@Mock
	private ProfessorRepository proRepo;
	@Mock
	private SubjectRepository subRepo;
	
	@InjectMocks
	private ProfessorServicelmpl proService;
	
	private Professor professor;
	private Subject subject;
	
	@BeforeEach
    public void setup(){
        //employeeRepository = Mockito.mock(EmployeeRepository.class);
        //employeeService = new EmployeeServiceImpl(employeeRepository);
        professor = new Professor();
        professor.setId(1);
        professor.setFullname("asd");
        professor.setSpecialty("no");
        subject =new Subject();
        subject.setDetails("asd");
                
    }
	
	@Test
    public void getAllProfessorTest(){   
        Professor pro = new Professor("dfsdf","sdf");
        given(proRepo.findAll()).willReturn(List.of(professor,pro));     
        List<Professor> proList = proService.getAllProfessor();
   
        assertThat(proList).isNotNull();
        assertThat(proList.size()).isEqualTo(2);
    }
	
	@Test
    public void getAllSubjectTest(){
		Subject sub = new Subject("dfsdf","sdf",professor);
        given(subRepo.findAll()).willReturn(List.of(subject,sub));     
        List<Subject> proList = proService.getAllSubjects();
   
        assertThat(proList).isNotNull();
        assertThat(proList.size()).isEqualTo(2);
    }
	
}

