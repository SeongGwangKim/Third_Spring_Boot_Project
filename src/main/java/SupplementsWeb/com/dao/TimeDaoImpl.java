package SupplementsWeb.com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TimeDaoImpl implements TimeDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String getTime() {
		return jdbcTemplate.queryForObject(getTime, String.class);
	}
}