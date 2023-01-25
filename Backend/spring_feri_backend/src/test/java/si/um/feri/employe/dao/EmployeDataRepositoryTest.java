package si.um.feri.employe.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import si.um.feri.employe.dto.EEmployePosition;
import si.um.feri.employe.dto.post.PostEmployeData;
import si.um.feri.employe.vao.Employe;
import si.um.feri.employe.vao.EmployeData;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ActiveProfiles("test")
public class EmployeDataRepositoryTest {

    @Autowired
    private EmployeRepository employeDao;

    @Autowired
    private EmployeDataRepository dao;

    Employe employe1;
    Employe employe2;

    @BeforeEach
    void beforeAll() {
        dao.deleteAll();
        employeDao.deleteAll();
        employe1=employeDao.save(new Employe(new si.um.feri.employe.dto.Employe(0,"Janez", "Novak", "00000001", EEmployePosition.DIRECTOR,9.0,2000, true)));
        employe2=employeDao.save(new Employe(new si.um.feri.employe.dto.Employe(0,"Tina", "Novak", "00000002", EEmployePosition.SENIOR_DEVELOPER,8.0,2000, true)));
    }

    @Test
    void countByEmployeTest() {
        assertEquals(0,dao.count());
        assertEquals(0,dao.countByEmploye(employe1));
        assertEquals(0,dao.countByEmploye(employe2));

        dao.save(new EmployeData(new PostEmployeData(0, 9.1, true),employe1));
        dao.save(new EmployeData(new PostEmployeData(0,9.2, true),employe1));
        dao.save(new EmployeData(new PostEmployeData(0,8.6, true),employe2));
        dao.save(new EmployeData(new PostEmployeData(0,8.7, true),employe2));
        dao.save(new EmployeData(new PostEmployeData(0,8.8, true),employe2));

        assertEquals(2,dao.countByEmploye(employe1));
        assertEquals(3,dao.countByEmploye(employe2));
    }

}
