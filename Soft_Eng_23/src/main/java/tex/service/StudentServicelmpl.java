package tex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tex.dao.ApplicationRepository;
import tex.dao.StudentRepository;
import tex.model.Application;
import tex.model.Student;

@Service
public class StudentServicelmpl implements StudentService {

	private StudentRepository studentRepository;
	private ApplicationRepository applicationRepository; 
	
	public StudentServicelmpl(StudentRepository studentRepository,ApplicationRepository applicationRepository) {
		super();
		this.studentRepository = studentRepository;
		this.applicationRepository=applicationRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Application> getAllAplications() {
		return applicationRepository.findAll();
	}

	@Override
	public Application saveApplication(Application application) {
		return applicationRepository.save(application);
	}
	
	
	
}
