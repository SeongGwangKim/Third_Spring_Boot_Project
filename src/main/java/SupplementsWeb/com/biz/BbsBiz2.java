package SupplementsWeb.com.biz;

import java.util.List;

import SupplementsWeb.com.dao.BbsDaoImpl2;
import SupplementsWeb.com.vo.BbsVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BbsBiz2 {
	
	@Autowired
	private BbsDaoImpl2 bbsDaoImpl2;

	public int getNextBbsIndex() {
		int res= bbsDaoImpl2.getNextBbsIndex();
		return res;
	}
	
	public int insertBbs(String bbsTitle, String userID, String bbsContent,int Category) {
		int res= bbsDaoImpl2.insertBbs(bbsTitle, userID, bbsContent, Category);
//		Commit(conn);
		return res;
	}
	
	public List<BbsVo2> getBBSByPage(int pageNumber){
		List<BbsVo2> res= bbsDaoImpl2.getBBSByPage(pageNumber);
		return res;
	}
	
	public boolean isEmptyNextPageBBS(int pageNumber) {
		boolean res= bbsDaoImpl2.isEmptyNextPageBBS(pageNumber);
		return res;
	}
	
	public BbsVo2 getBBSByID(int bbsID) {
		BbsVo2 res= bbsDaoImpl2.getBBSByID(bbsID);
		return res;
	}
	
	public int updateBBS(int bbsID, String bbsTitle, String bbsContent) {
		int res= bbsDaoImpl2.updateBBS(bbsID, bbsTitle, bbsContent);
//		Commit(conn);
		return res;
	}
	
	public int deleteBBS(int bbsID) {
		int res= bbsDaoImpl2.deleteBBS(bbsID);
//		Commit(conn);
		return res;
	}
	
	public int getBBSView(int bbsID) {
		int res= bbsDaoImpl2.getBBSView(bbsID);
		return res;
	}

	public int plusBbsView(int bbsID, int bbsView) {
		int res= bbsDaoImpl2.plusBbsView(bbsID, bbsView);
//		Commit(conn);
		return res;
	}

	public List<BbsVo2> searchByBBSTitle(int pageNumber,String text){
		List<BbsVo2> res= bbsDaoImpl2.searchByBBSTitle(text,pageNumber);
		return res;
	}
	
	public List<BbsVo2> searchByUserID(int pageNumber,String text){
		List<BbsVo2> res= bbsDaoImpl2.searchByUserID(text,pageNumber);
		return res;
	}
	
	public List<BbsVo2> searchByBBSContent(int pageNumber,String text){
		List<BbsVo2> res= bbsDaoImpl2.searchByBBSContent(text,pageNumber);
		return res;
	}
	
	public int getNewNext2() {
		int res= bbsDaoImpl2.getNewNext2();
//		Commit(conn);
		return res;
	}
}
