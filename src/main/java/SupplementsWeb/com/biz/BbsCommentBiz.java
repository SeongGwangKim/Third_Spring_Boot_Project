package SupplementsWeb.com.biz;


import SupplementsWeb.com.dao.BbsCommentDaoImpl;
import SupplementsWeb.com.vo.BbsCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BbsCommentBiz {

	@Autowired
	private BbsCommentDaoImpl bbsCommentDaoImpl;
	
	
	public List<BbsCommentVo> getAllComments(int bbsNo){
		List<BbsCommentVo> res= bbsCommentDaoImpl.getAllComments(bbsNo);
		return res;
	}
	
	public int getNextCommentsIndex() {
		int res= bbsCommentDaoImpl.getNextCommentsIndex();
		return res;
	}
	
	public int insertComments(int bbsID, String userID, String commentText) {
		int res= bbsCommentDaoImpl.insertComments(bbsID, userID, commentText);
//		Commit(conn);
		return res;
	}
	
	public BbsCommentVo getCommentsByID(int commentID) {
		BbsCommentVo res= bbsCommentDaoImpl.getCommentsByID(commentID);
		return res;
	}
	
	public int updateComments(int commentID, String commentText) {
		int res= bbsCommentDaoImpl.updateComments(commentID, commentText);
//		Commit(conn);
		return res;
	}
	
	public int deleteComments(int commentID) {
		int res= bbsCommentDaoImpl.deleteComments(commentID);
//		Commit(conn);
		return res;
	}
}
