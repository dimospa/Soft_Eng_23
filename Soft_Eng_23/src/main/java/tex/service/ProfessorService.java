package tex.service;

import java.util.List;
import tex.model.Professor;
import tex.model.*;
public interface ProfessorService {
	
	List<Professor> getAllProfessor();
	Professor saveProfessor(Professor professor);
	
	List<Subject> getAllSubjects();
	Subject saveSubject(Subject subject);
	
	
}
