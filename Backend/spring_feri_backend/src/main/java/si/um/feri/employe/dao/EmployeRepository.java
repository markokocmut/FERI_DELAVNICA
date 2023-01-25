package si.um.feri.employe.dao;

import org.springframework.data.repository.CrudRepository;
import si.um.feri.employe.vao.Employe;

public interface EmployeRepository extends CrudRepository<Employe, Integer> {
	
}