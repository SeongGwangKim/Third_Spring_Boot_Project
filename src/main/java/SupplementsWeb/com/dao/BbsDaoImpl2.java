package SupplementsWeb.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import SupplementsWeb.com.vo.BbsVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;



@Repository
public class BbsDaoImpl2 extends JdbcDaoSupport implements BbsDao2{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private TimeDaoImpl timeDaoImpl;

	public int getNextBbsIndex() {
		return jdbcTemplate.queryForObject(getNextBbsIndex, Integer.class)+1;
	}
	
	public int insertBbs(String bbsTitle, String userID, String bbsContent,int Category) {
		return jdbcTemplate.update(insertBBS, 
				new Object[] {getNextBbsIndex(), bbsTitle, userID,
						timeDaoImpl.getTime(), bbsContent, 1, 1, 0
		});
	}
	
	public List<BbsVo2> getBBSByPage(int pageNumber){
/*
		return jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(getBBSByPage);
				// 인덱스 파라미터 값 설정
				pstmt.setInt(1, (getNextBbsIndex() - (pageNumber - 1) * 10));

				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}, new RowMapper<BbsVo2>(){
				@Override
					public BbsVo2 mapRow(ResultSet rs, int rowNum) throws SQLException {
						BbsVo2 entity = new BbsVo2();
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

			});
*/

			RowMapper<BbsVo2> rowMapper = (rs, rowNum) -> {
				BbsVo2 entity = new BbsVo2();
				entity.setBbsID(rs.getInt(1));
				entity.setBbsTitle(rs.getString(2));
				entity.setUserID(rs.getString(3));
				entity.setBbsDate(rs.getString(4));
				entity.setBbsContent(rs.getString(5));
				entity.setBbsAvailable(rs.getInt(6));
				entity.setBbsCategory(rs.getInt(7));
				entity.setBbsView(rs.getInt(8));
				return entity;
			};

		return jdbcTemplate.query(getBBSByPage,
				new Object[] {(getNextBbsIndex() - (pageNumber - 1) * 10 )}, rowMapper);
			}


	public boolean isEmptyNextPageBBS(int pageNumber) {
		try{
			RowMapper<BbsVo2> rowMapper = new RowMapper<BbsVo2>() {
				@Override
				public BbsVo2 mapRow(ResultSet rs, int rowNum) throws SQLException {
					BbsVo2 entity = new BbsVo2();
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
			};
			jdbcTemplate.query(isEmptyNextPageBBS, new Object[] {(getNextBbsIndex() - (pageNumber - 1) * 10 )}, rowMapper);
			return true;
		}catch (EmptyResultDataAccessException e) {
			return false;
		}

	}
	public BbsVo2 getBBSByID(int bbsID) {
		return jdbcTemplate.queryForObject(getBBSByID, new Object[]{bbsID},
				(rs, rowNum) -> {
					BbsVo2 entity = new BbsVo2();
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
				new Object[] {bbsID}, Integer.class);
	}


	public int plusBbsView(int bbsID, int bbsView) {
		return jdbcTemplate.update(plusBbsView, new Object[]{bbsView, bbsID});
	}

	public List<BbsVo2> searchByBBSTitle(String searchText, int pageNumber){

		RowMapper<BbsVo2> rowMapper = (rs, rowNum) -> {
			BbsVo2 entity = new BbsVo2();
			entity.setBbsID(rs.getInt(1));
			entity.setBbsTitle(rs.getString(2));
			entity.setUserID(rs.getString(3));
			entity.setBbsDate(rs.getString(4));
			entity.setBbsContent(rs.getString(5));
			entity.setBbsAvailable(rs.getInt(6));
			entity.setBbsCategory(rs.getInt(7));
			entity.setBbsView(rs.getInt(8));
			return entity;
		};

		return jdbcTemplate.query(searchByBBSTitle,
				new Object[]{searchText, pageNumber}, rowMapper);
	}

	public List<BbsVo2> searchByUserID(String searchText, int pageNumber){
		RowMapper<BbsVo2> rowMapper = (rs, rowNum) -> {
			BbsVo2 entity = new BbsVo2();
			entity.setBbsID(rs.getInt(1));
			entity.setBbsTitle(rs.getString(2));
			entity.setUserID(rs.getString(3));
			entity.setBbsDate(rs.getString(4));
			entity.setBbsContent(rs.getString(5));
			entity.setBbsAvailable(rs.getInt(6));
			entity.setBbsCategory(rs.getInt(7));
			entity.setBbsView(rs.getInt(8));
			return entity;
		};

		return jdbcTemplate.query(searchByUserID,
				new Object[]{searchText, pageNumber}, rowMapper);
	}

	public List<BbsVo2> searchByBBSContent(String searchText, int pageNumber){
		RowMapper<BbsVo2> rowMapper = (rs, rowNum) -> {
			BbsVo2 entity = new BbsVo2();
			entity.setBbsID(rs.getInt(1));
			entity.setBbsTitle(rs.getString(2));
			entity.setUserID(rs.getString(3));
			entity.setBbsDate(rs.getString(4));
			entity.setBbsContent(rs.getString(5));
			entity.setBbsAvailable(rs.getInt(6));
			entity.setBbsCategory(rs.getInt(7));
			entity.setBbsView(rs.getInt(8));
			return entity;
		};

		return jdbcTemplate.query(searchByBBSContent,
				new Object[]{searchText, pageNumber}, rowMapper);
	}

	public int getNewNext2() {
		return jdbcTemplate.queryForObject(upload, Integer.class)+1;
	}
}
