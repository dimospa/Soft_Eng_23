package tex.serviceTests;

import tex.dao.*;
import tex.model.*;
import tex.service.ProfessorService;
import tex.service.ProfessorServicelmpl;
import tex.service.StudentServicelmpl;

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
public class StudentServiceTest {
	@Mock
	private StudentRepository stuRepo;
	@Mock
	private ApplicationRepository appRepo;
	
	@InjectMocks
	private StudentServicelmpl stuService;
	
	private Student student;
	private Application application;
	
	@BeforeEach
    public void setup(){       
        student = new Student();
        student.setId(1);
        student.setFullname("nikos");
        student.setCurrentaveragegrade(10.2);
        student.setRemainingcourses(7);
        student.setYearofstudies(4);
        
        application =new Application();
        application.setId(1);
        application.setStudent(student);
                     
    }
	
	@Test
    public void getAllStudentTest(){   
        Student stud=new Student("asd",10,5.8,3);
        given(stuRepo.findAll()).willReturn(List.of(student,stud));     
        List<Student> stuList = stuService.getAllStudents();
   
        assertThat(stuList).isNotNull();
        assertThat(stuList.size()).isEqualTo(2);
    }
	
	@Test
    public void getAllApplicationsTest(){
		Application app=new Application(student);
        given(appRepo.findAll()).willReturn(List.of(application,app));     
        List<Application> appList = stuService.getAllAplications();
   
        assertThat(appList).isNotNull();
        assertThat(appList.size()).isEqualTo(2);
    }
	
}
