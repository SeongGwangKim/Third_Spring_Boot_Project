package SupplementsWeb.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import SupplementsWeb.com.vo.BbsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;



@Repository
public class BbsDaoImpl extends JdbcDaoSupport implements BbsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private TimeDaoImpl timeDaoImpl;

	public int getNextBbsIndex() {
		return jdbcTemplate.queryForObject(getNextBbsIndex, Integer.class) + 1;
	}

	public int insertBbs(String bbsTitle, String userID, String bbsContent, int Category) {
		return jdbcTemplate.update(insertBBS,
				new Object[]{getNextBbsIndex(), bbsTitle, userID,
						timeDaoImpl.getTime(), bbsContent, 1, 1, 0
				});
	}

	public List<BbsVo> getBBSByPage(int pageNumber) {
		return jdbcTemplate.query(getBBSByPage,
				new Object[]{(getNextBbsIndex() - (pageNumber - 1) * 10)}, new rowMapper());
	}

	public boolean isEmptyNextPageBBS(int pageNumber) {
		try {
			jdbcTemplate.query(isEmptyNextPageBBS, new Object[]{(getNextBbsIndex() - (pageNumber - 1) * 10)}, new rowMapper());
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}

	}

	public BbsVo getBBSByID(int bbsID) {
		return jdbcTemplate.queryForObject(getBBSByID, new Object[]{bbsID},
				(rs, rowNum) -> {
					BbsVo entity = new BbsVo();
					entity.setBbsID(rs.getInt(1));
					entity.setBbsTitle(rs.getString(2));
					entity.setUserID(rs.getString(3));
					entity.setBbsDate(rs.getString(4));
					entity.setBbsContent(rs.getString(5));
					entity.setBbsAvailable(rs.getInt(6));
					entity.setBbsCategory(rs.getInt(7));
					entity.setBbsView(rs.getInt(8));

					return entity;
				});
	}

	public int updateBBS(int bbsID, String bbsTitle, String bbsContent) {
		return jdbcTemplate.update(updateBBS, new Object[]{bbsTitle, bbsContent, bbsID});
	}

	public int deleteBBS(int bbsID) {
		return jdbcTemplate.update(deleteBBS, new Object[]{bbsID});
	}

	public int getBBSView(int bbsID) {
		return jdbcTemplate.queryForObject(getBbsView,
				new Object[]{bbsID}, Integer.class);
	}

	public int plusBbsView(int bbsID, int bbsView) {
		return jdbcTemplate.update(plusBbsView, new Object[]{bbsView, bbsID});
	}

	public List<BbsVo> searchByBBSTitle(String searchText, int pageNumber) {
		return jdbcTemplate.query(searchByBBSTitle,
				new Object[]{searchText, pageNumber}, new rowMapper());
	}

	public List<BbsVo> searchByUserID(String searchText, int pageNumber) {
		return jdbcTemplate.query(searchByUserID,
				new Object[]{searchText, pageNumber}, new rowMapper());
	}

	public List<BbsVo> searchByBBSContent(String searchText, int pageNumber) {
		return jdbcTemplate.query(searchByBBSContent,
				new Object[]{searchText, pageNumber}, new rowMapper());
	}

	public int getNewNext() {
		return jdbcTemplate.queryForObject(upload, Integer.class) + 1;
	}

	public class rowMapper implements RowMapper<BbsVo> {
		@Override
		public BbsVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			BbsVo entity = new BbsVo();
			entity.setBbsID(rs.getInt(1));
			entity.setBbsTitle(rs.getString(2));
			entity.setUserID(rs.getString(3));
			entity.setBbsDate(rs.getString(4));
			entity.setBbsContent(rs.getString(5));
			entity.setBbsAvailable(rs.getInt(6));
			entity.setBbsCategory(rs.getInt(7));
			entity.setBbsView(rs.getInt(8));
			return entity;
		}

	}
}

