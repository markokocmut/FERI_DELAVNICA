package si.um.feri.employe.dto.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public record PostEmployeDataResponse(
		String result) {}
