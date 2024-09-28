package tex.service;

import java.util.List;
import tex.model.Application;
import tex.model.Student;

public interface StudentService {

	List<Student> getAllStudents();
	Student saveStudent(Student student);
	
	List<Application> getAllAplications();
	Application saveApplication(Application application);
}
