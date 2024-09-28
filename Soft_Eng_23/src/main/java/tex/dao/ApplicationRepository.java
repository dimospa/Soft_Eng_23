package tex.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tex.model.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer> {

}
