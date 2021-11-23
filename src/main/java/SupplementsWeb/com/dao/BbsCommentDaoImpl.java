package SupplementsWeb.com.dao;

import java.util.List;

import SupplementsWeb.com.vo.BbsCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BbsCommentDaoImpl extends JdbcDaoSupport implements BbsCommentDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int getNextCommentsIndex() {
		return jdbcTemplate.queryForObject(getNextCommentsIndex, Integer.class);

	}
	
	
	public int insertComments(int bbsID, String userID, String commentText) {
			return jdbcTemplate.update(insertComments,
					new Object[]{getNextCommentsIndex(), bbsID, userID, commentText});

	}

	public List<BbsCommentVo> getAllComments(int bbsNo){
		RowMapper<BbsCommentVo> rowMapper = (rs, rowNum) -> {
			BbsCommentVo entity = new BbsCommentVo();
			entity.setCommentID(rs.getInt(1));
			entity.setBbsID(rs.getInt(2));
			entity.setUserID(rs.getString(3));
			entity.setCommentText(rs.getString(4));

			return entity;
		};
		return jdbcTemplate.query(getAllComments, new Object[]{bbsNo}, rowMapper);

	}
	public BbsCommentVo getCommentsByID(int commentID) {
			RowMapper<BbsCommentVo> rowMapper = (rs, rowNum) -> {
				BbsCommentVo entity = new BbsCommentVo();
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
