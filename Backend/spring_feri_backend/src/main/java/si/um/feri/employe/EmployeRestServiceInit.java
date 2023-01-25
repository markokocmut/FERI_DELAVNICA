package si.um.feri.employe;

import si.um.feri.employe.dao.EmployeDataRepository;
import si.um.feri.employe.dao.EmployeRepository;
import si.um.feri.employe.dto.EEmployePosition;
import si.um.feri.employe.dto.post.PostEmployeData;
import si.um.feri.employe.vao.EmployeData;
import si.um.feri.employe.vao.Employe;
import java.util.logging.Logger;

public class EmployeRestServiceInit {

	private static final Logger log = Logger.getLogger(EmployeRestServiceInit.class.toString());

	void populateTestDataIfNotPresent( EmployeRepository daoEmployes, EmployeDataRepository daoLogData) {
		if (daoEmployes.count()>0) {
			log.info("populateTestData - skipped.");
			return;
		}
		log.info("populateTestData initiated.");
		
		Employe p1=new Employe();
		p1.setFirstName("Janez");
		p1.setLastName("Novak");
		p1.setTaxCode("00000001");
		p1.setEmployed(true);
		p1.setPosition(EEmployePosition.DIRECTOR);
		p1.setSalaryFactor(8.0);
		daoEmployes.save(p1);

		Employe p2=new Employe();
		p2.setFirstName("Janez");
		p2.setLastName("Horvat");
		p2.setTaxCode("00000002");
		p2.setEmployed(true);
		p2.setPosition(EEmployePosition.BEGIN_DEVELOPER);
		p2.setSalaryFactor(4.0);
		daoEmployes.save(p2);

		//PostEmployeData pm1 = new PostEmployeData(p1.getId(),8.5, true);
		//daoLogData.save(new EmployeData(pm1,p1));

		//PostEmployeData pm2=new PostEmployeData(p2.getId(),4.5, true);
		//daoLogData.save(new EmployeData(pm2,p2));
	}
	
}
