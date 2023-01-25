package si.um.feri.employe.dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import si.um.feri.employe.dto.EEmployePosition;
import si.um.feri.employe.dto.Employe;
import si.um.feri.employe.dto.EmployeData;
import si.um.feri.employe.dto.post.PostEmployeData;
import si.um.feri.employe.rest.EmployeHistoryController;
import si.um.feri.employe.rest.EmployePostController;
import si.um.feri.employe.rest.EmployeController;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
//@ActiveProfiles("test")
public class RestScenarioTest {

    @Autowired
    EmployeController employeRest;

    @Autowired
    EmployePostController employeDataPostRest;

    @Autowired
    EmployeHistoryController employeDataHistoryRest;

    Employe newEmploye=null;

    @BeforeEach
    void createEmploye() {
        newEmploye = employeRest.postEmploye( new Employe(0,"Janez","Novak","000000001", EEmployePosition.DIRECTOR, 8.0, 0.0, true)).getBody();
    }

    @Test
    void checkEmployeExistence() {
        Employe fromServer = employeRest.getEmployeById(newEmploye.id()).getBody();
        assertEquals(fromServer.taxCode(),newEmploye.taxCode());
    }

    @Test
    void newOKEmploye() {
        String result= employeDataPostRest.postEmployeSalary( new PostEmployeData(newEmploye.id(),8.5, true) ).getBody().result();
        assertEquals("ok",result);
    }

    @Test
    void newSalaryForFakeEmploye() {
        Object res=employeDataPostRest.postEmployeSalary(new PostEmployeData(1111, 7.6, true)).getBody();
        assertInstanceOf(String.class,res);
        assertEquals("employe-not-found",res.toString());
    }

    @Test
    void newNotOKEmployeSalary() {
        String result= employeDataPostRest.postEmployeSalary(new PostEmployeData(newEmploye.id(), 23.5, true)).getBody().result();
        assertEquals("not_ok",result);
    }

    @Test
    void employeHistory() {
        // Two elements are entered upon inicialization
        employeDataPostRest.postEmployeSalary(new PostEmployeData(newEmploye.id(), 8.0, true));
        employeDataPostRest.postEmployeSalary(new PostEmployeData(newEmploye.id(),8.1, true));
        employeDataPostRest.postEmployeSalary(new PostEmployeData(newEmploye.id(),8.2, true));

        List<EmployeData> history=new ArrayList<>();
        employeDataHistoryRest.getHistory().forEach(m->history.add(m));

        assertEquals(5,history.size());
    }

}
