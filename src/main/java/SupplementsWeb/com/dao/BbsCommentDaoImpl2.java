package SupplementsWeb.com.dao;

import SupplementsWeb.com.vo.BbsCommentVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class BbsCommentDaoImpl2 extends JdbcDaoSupport implements BbsCommentDao2{


	@Autowired
	JdbcTemplate jdbcTemplate;

	public int getNextCommentsIndex() {
		return jdbcTemplate.queryForObject(getNextCommentsIndex, Integer.class);

	}


	public int insertComments(int bbsID, String userID, String commentText) {
		return jdbcTemplate.update(insertComments,
				new Object[]{getNextCommentsIndex(), bbsID, userID, commentText});

	}

	public List<BbsCommentVo2> getAllComments(int bbsNo){
		RowMapper<BbsCommentVo2> rowMapper = (rs, rowNum) -> {
			BbsCommentVo2 entity = new BbsCommentVo2();
			entity.setCommentID(rs.getInt(1));
			entity.setBbsID(rs.getInt(2));
			entity.setUserID(rs.getString(3));
			entity.setCommentText(rs.getString(4));

			return entity;
		};
		return jdbcTemplate.query(getAllComments, new Object[]{bbsNo}, rowMapper);

	}
	public BbsCommentVo2 getCommentsByID(int commentID) {
		RowMapper<BbsCommentVo2> rowMapper = (rs, rowNum) -> {
			BbsCommentVo2 entity = new BbsCommentVo2();
			entity.setCommentID(rs.getInt(1));
			entity.setBbsID(rs.getInt(2));
			entity.setUserID(rs.getString(3));
			entity.setCommentText(rs.getString(4));

			return entity;
		};
		return jdbcTemplate.queryForObject(getCommentsByID, new Object[]{commentID}, rowMapper);

	}

	public int updateComments(int commentID, String commentText) {
		return jdbcTemplate.update(updateComments, new Object[]{commentText, commentID});
	}

	public int deleteComments(int commentID) {
		return jdbcTemplate.update(deleteComments, new Object[]{commentID});

	}
}
