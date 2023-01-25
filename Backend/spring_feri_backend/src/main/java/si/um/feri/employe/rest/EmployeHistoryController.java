package si.um.feri.employe.rest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import si.um.feri.employe.dao.EmployeDataRepository;

@CrossOrigin
@RestController
public class EmployeHistoryController {

	@Autowired
	private EmployeDataRepository dao;

	@Value("${history.dayslimit}")
	private int envHistoryDayslimit;

	@GetMapping("/history")
	public @ResponseBody Iterable<si.um.feri.employe.dto.EmployeData> getHistory() {
		long history = System.currentTimeMillis() - envHistoryDayslimit * 3_600_000 * 24;
		LocalDateTime historyDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(history),TimeZone.getDefault().toZoneId());
		List<si.um.feri.employe.dto.EmployeData> ret = new ArrayList<>();
		dao.findByCreatedGreaterThan(historyDate).forEach(m->ret.add(m.toDto()));
		return ret;
	}

}