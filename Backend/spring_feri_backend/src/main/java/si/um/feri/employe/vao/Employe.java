package si.um.feri.employe.vao;

import lombok.Data;
import lombok.NoArgsConstructor;
import si.um.feri.employe.dto.EEmployePosition;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Employe {

    public Employe(si.um.feri.employe.dto.Employe dto) {
        setFirstName(dto.firstName());
        setLastName(dto.lastName());
        setTaxCode(dto.taxCode());
        setPosition(dto.position());
        setSalaryFactor(dto.salaryFactor());
        setEmployed(dto.employed());
    }

    public void updateFrom(si.um.feri.employe.dto.Employe dto) {
        setId(dto.id());
        setFirstName(dto.firstName());
        setLastName(dto.lastName());
        setTaxCode(dto.taxCode());
        setPosition(dto.position());
        setSalaryFactor(dto.salaryFactor());
        setEmployed(dto.employed());
    }

    public si.um.feri.employe.dto.Employe toDto() {
        return new si.um.feri.employe.dto.Employe(
                getId(),
                getFirstName(),
                getLastName(),
                getTaxCode(),
                getPosition(),
                getSalaryFactor(),
                getSalary(),
                isEmployed());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    private String taxCode;

    protected LocalDateTime created=LocalDateTime.now();

    protected String firstName;

    protected String lastName;

    protected EEmployePosition position;

    protected double salaryFactor;

    protected boolean employed;

    protected double getSalary(){
        return EEmployePosition.getBasicSalary() * salaryFactor;
    }

}
