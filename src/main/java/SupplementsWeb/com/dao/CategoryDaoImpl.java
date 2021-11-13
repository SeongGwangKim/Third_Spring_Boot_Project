package SupplementsWeb.com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	public String getCategory(int categoryNum){
		return jdbcTemplate.queryForObject(getCategory, String.class);

	}
}
