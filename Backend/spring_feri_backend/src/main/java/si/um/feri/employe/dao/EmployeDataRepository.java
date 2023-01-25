package si.um.feri.employe.dao;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import si.um.feri.employe.vao.Employe;
import si.um.feri.employe.vao.EmployeData;

public interface EmployeDataRepository extends CrudRepository<EmployeData, Integer> {

	Long countByEmploye(Employe p);

	List<EmployeData> findByCreatedGreaterThan(LocalDateTime created);
	
}