package si.um.feri.employe.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import si.um.feri.employe.dao.EmployeRepository;
import si.um.feri.employe.vao.Employe;

@CrossOrigin
@RestController
public class EmployeController {

	private static final Logger log = Logger.getLogger(EmployeController.class.toString());

	@Autowired
	private EmployeRepository dao;

	@GetMapping("/employees")
	public @ResponseBody Iterable<si.um.feri.employe.dto.Employe> getAllEmployees() {
		List<si.um.feri.employe.dto.Employe> ret=new ArrayList<>();
		dao.findAll().forEach(p -> ret.add(p.toDto()));
		return ret;
	}
	
	@GetMapping("/employe/{id}")
	public @ResponseBody ResponseEntity<si.um.feri.employe.dto.Employe> getEmployeById(@PathVariable("id") int id) {
		//validate
		Optional<Employe> val=dao.findById(id);
		if (val.isEmpty()) {
			log.info(()->"/employe/"+id+" ; Employe not found!");
			return new ResponseEntity("employe-not-found",HttpStatus.NOT_ACCEPTABLE);
		}
		return ResponseEntity.ok(val.get().toDto());
	}
	
	@PostMapping("/employe")
	public ResponseEntity<si.um.feri.employe.dto.Employe> postEmploye(@RequestBody si.um.feri.employe.dto.Employe pc) {
		Employe vao = dao.save(new Employe(pc));
	    return ResponseEntity.ok(vao.toDto());
	}
	
	@PutMapping("/employe/{id}")
	public ResponseEntity<si.um.feri.employe.dto.Employe> putEmploye(@PathVariable("id") int id, @RequestBody si.um.feri.employe.dto.Employe v) {
		//validate
		Optional<Employe> val=dao.findById(id);
		if (val.isEmpty()) {
			log.info("/employe/"+id+" ; Product not found!");
			return new ResponseEntity("employe-not-found",HttpStatus.NOT_ACCEPTABLE);
		}
				
		Employe vao=val.get();
		vao.updateFrom(v);
		vao=dao.save(vao);
	    return ResponseEntity.ok(vao.toDto());
	}
	
	@DeleteMapping("/employe/{id}")
	public ResponseEntity<String> deleteEmploye(@PathVariable("id") int id) {
		//validate
		Optional<Employe> val=dao.findById(id);
		if (val.isEmpty()) {
			log.info("/employe/"+id+" ; Employe not found!");
			return new ResponseEntity("emyploye-not-found",HttpStatus.NOT_ACCEPTABLE);
		}
		Employe vao=val.get();
		dao.delete(vao);
	    return ResponseEntity.ok("deleted");
	}

}