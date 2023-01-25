package si.um.feri.employe.rest;

import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import si.um.feri.employe.dao.EmployeDataRepository;
import si.um.feri.employe.dao.EmployeRepository;
import si.um.feri.employe.dto.post.PostEmployeData;
import si.um.feri.employe.dto.post.PostEmployeDataResponse;
import si.um.feri.employe.vao.EmployeData;
import si.um.feri.employe.vao.Employe;

@CrossOrigin
@RestController
public class EmployePostController {

	private static final Logger log = Logger.getLogger(EmployePostController.class.toString());

	@Autowired
	private EmployeDataRepository dao;

	@Autowired
	private EmployeRepository employeDao;
	
	@PostMapping("/employe_salary")
	public ResponseEntity<PostEmployeDataResponse> postEmployeSalary(@RequestBody PostEmployeData m) {
		//validate
		Optional<Employe> val=employeDao.findById(m.id());
		if (val.isEmpty()) {
			log.info(()->"/employe_salary sent: "+m+"; Employe not found!");
			return new ResponseEntity("employe-not-found",HttpStatus.NOT_ACCEPTABLE);
		}
		Employe employe = val.get();

		EmployeData vao=new EmployeData(m, employe);
		boolean ok=true;

		//action?
		if (m.salaryFactor() < employe.getPosition().getMinSalaryFactor()) {
			log.info(()->"/employe_salary sent: "+m+"; employe: "+employe+"; ACTION NEEDED-lower");
			ok=false;
		}
		if (m.salaryFactor() > employe.getPosition().getMaxSalaryFactor()) {
			log.info(()->"/employe_salary sent: "+m+"; employe: "+employe+"; ACTION NEEDED-higher");
			ok=false;
		}
		employe.setSalaryFactor(m.salaryFactor());
		employe.setEmployed(m.employed());
		//save
		vao.setOk(ok);

		employeDao.save(employe);

		dao.save(vao);

		//response
	    return ResponseEntity.ok(new PostEmployeDataResponse(ok?"ok":"not_ok"));
	}
	
}