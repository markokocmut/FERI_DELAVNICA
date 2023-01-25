package si.um.feri.employe.vao;

import lombok.Data;
import lombok.NoArgsConstructor;
import si.um.feri.employe.dto.post.PostEmployeData;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor
public class EmployeData {

    public EmployeData(PostEmployeData m, Employe p) {
        this.value = m.salaryFactor();
        this.employed = m.employed();
        this.employe = p;
    }

    public si.um.feri.employe.dto.EmployeData toDto() {
        return new si.um.feri.employe.dto.EmployeData(
                id,
                si.um.feri.employe.dto.EmployeData.JSON_DATE_FORMAT.format(created),
                (employe != null) ? employe.getId() : -1,
                value,
                employed,
                isOk
        );
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "levelValue")
    private double value;

    private LocalDateTime created=LocalDateTime.now();

    @Column(name = "employed")
    private boolean employed;

    private boolean isOk = true;

    @ManyToOne
    private Employe employe;
}
