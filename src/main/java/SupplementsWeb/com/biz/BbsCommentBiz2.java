package SupplementsWeb.com.biz;


import SupplementsWeb.com.dao.BbsCommentDaoImpl2;
import SupplementsWeb.com.vo.BbsCommentVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BbsCommentBiz2 {

	@Autowired
	private BbsCommentDaoImpl2 bbsCommentDaoImpl2;


	public List<BbsCommentVo2> getAllComments(int bbsNo){
		List<BbsCommentVo2> res= bbsCommentDaoImpl2.getAllComments(bbsNo);
		return res;
	}

	public int getNextCommentsIndex() {
		int res= bbsCommentDaoImpl2.getNextCommentsIndex();
		return res;
	}

	public int insertComments(int bbsID, String userID, String commentText) {
		int res= bbsCommentDaoImpl2.insertComments(bbsID, userID, commentText);
//		Commit(conn);
		return res;
	}

	public BbsCommentVo2 getCommentsByID(int commentID) {
		BbsCommentVo2 res= bbsCommentDaoImpl2.getCommentsByID(commentID);
		return res;
	}

	public int updateComments(int commentID, String commentText) {
		int res= bbsCommentDaoImpl2.updateComments(commentID, commentText);
//		Commit(conn);
		return res;
	}

	public int deleteComments(int commentID) {
		int res= bbsCommentDaoImpl2.deleteComments(commentID);
//		Commit(conn);
		return res;
	}
}
