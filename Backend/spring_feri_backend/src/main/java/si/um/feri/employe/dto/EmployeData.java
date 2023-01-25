package si.um.feri.employe.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.format.DateTimeFormatter;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record EmployeData(
    int id,
    String date,
    int employeId,
    double salaryFactor,
    boolean isEmployed,
    boolean isOk) {
        public static final DateTimeFormatter JSON_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
}
