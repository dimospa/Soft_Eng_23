package tex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tex.dao.*;
import tex.dao.ProfessorRepository;
import tex.model.Professor;
import tex.model.Subject;

@Service
public class ProfessorServicelmpl implements ProfessorService {

	private ProfessorRepository professorRepository;
	private SubjectRepository subjectRepository;
	
	public ProfessorServicelmpl(ProfessorRepository professorRepository,SubjectRepository subjectRepository) {
		super();
		this.professorRepository = professorRepository;
		this.subjectRepository = subjectRepository;
	}

	@Override
	public List<Professor> getAllProfessor() {
		
		return professorRepository.findAll();
	}

	@Override
	public Professor saveProfessor(Professor professor) {
		
		return professorRepository.save(professor);
	}

	@Override
	public List<Subject> getAllSubjects() {
		
		return subjectRepository.findAll();
	}

	@Override
	public Subject saveSubject(Subject subject) {
		
		return subjectRepository.save(subject);
	}

	
	
}
