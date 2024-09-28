package tex.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tex.model.*;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Integer> {

}
