package si.um.feri.employe.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import si.um.feri.employe.dto.EEmployePosition;
import si.um.feri.employe.vao.Employe;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ActiveProfiles("test")
public class EmployeRepositoryTest {

    @Autowired
    private EmployeRepository dao;

    @Autowired
    private EmployeDataRepository dataDao;

    Employe employe;

    @BeforeEach
    void beforeEach() {
        dataDao.deleteAll();
        dao.deleteAll();
        employe = dao.save(new Employe(new si.um.feri.employe.dto.Employe(0,"Janet","Novak","000000001", EEmployePosition.BEGIN_DEVELOPER, 6.0, 1600.0, true)));
    }

    @Test
    void addAnotherEmployeTest() {
        assertEquals(1,dao.count());
        assertEquals("Janet", employe.getFirstName());
        assertEquals("Novak", employe.getLastName());
        assertEquals(EEmployePosition.BEGIN_DEVELOPER, employe.getPosition());
        assertEquals(6.0, employe.getSalaryFactor(), 0.00001);

        Employe p=new Employe();
        p.setFirstName("Darko");
        p.setLastName("Marko");
        p.setEmployed(true);
        p.setTaxCode("00000008");
        p.setPosition(EEmployePosition.SENIOR_DEVELOPER);
        p.setSalaryFactor(8.5);
        p=dao.save(p);

        assertEquals(2,dao.count());

        Optional<Employe> optP=dao.findById(p.getId());
        assertFalse(optP.isEmpty());
        assertNotNull(optP.get());
        p=optP.get();

        assertEquals("Darko",p.getFirstName());
        assertEquals(8.5,p.getSalaryFactor(),0.0001);
    }

    @Test
    void deleteEmployeTest() {
        assertEquals(1,dao.count());
        dao.deleteById(employe.getId());
        assertEquals(0,dao.count());
    }
}
