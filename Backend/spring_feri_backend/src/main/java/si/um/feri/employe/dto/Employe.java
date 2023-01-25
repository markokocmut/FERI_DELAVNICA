package si.um.feri.employe.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record Employe(
        int id,
        String firstName,
        String lastName,
        String taxCode,
        EEmployePosition position,
        double salaryFactor,
        double salary,
        boolean employed
        ) {}
