package tex.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tex.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
