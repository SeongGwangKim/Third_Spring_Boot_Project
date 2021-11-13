package SupplementsWeb.com.biz;

import SupplementsWeb.com.dao.BbsDaoImpl;
import SupplementsWeb.com.vo.BbsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BbsBiz {
	
	
	@Autowired
	private BbsDaoImpl bbsDaoImpl;
	
	
	public int getNextBbsIndex() {
		int res= bbsDaoImpl.getNextBbsIndex();
		return res;
	}
	
	public int insertBbs(String bbsTitle, String userID, String bbsContent, int Category) {
		int res=  bbsDaoImpl.insertBbs(bbsTitle, userID, bbsContent, Category);
//		Commit(conn);
		return res;
	}
	
	public List<BbsVo> getBBSByPage(int pageNumber){
		List<BbsVo> res= bbsDaoImpl.getBBSByPage(pageNumber);
		return res;
	}
	
	public boolean isEmptyNextPageBBS(int pageNumber) {
		boolean res= bbsDaoImpl.isEmptyNextPageBBS(pageNumber);
		return res;
	}
	public BbsVo getBBSByID(int bbsID) {
		BbsVo res= bbsDaoImpl.getBBSByID(bbsID);
		return res;
	}
	
	public int updateBBS(int bbsID, String bbsTitle, String bbsContent) {
		int res= bbsDaoImpl.updateBBS(bbsID, bbsTitle, bbsContent);
//		Commit(conn);
		return res;
	}
	public int deleteBBS(int bbsID) {
		int res= bbsDaoImpl.deleteBBS(bbsID);
//		Commit(conn);
		return res;
	}
	
	public int getBBSView(int bbsID) {
		int res= bbsDaoImpl.getBBSView(bbsID);
		return res;
	}
	
	public int plusBbsView(int bbsID, int bbsView) {
		int res= bbsDaoImpl.plusBbsView(bbsID, bbsView);
//		Commit(conn);
//		Close(conn);
		return res;
	}
	
	public List<BbsVo> searchByBBSTitle(int pageNumber, String text){
		List<BbsVo> res= bbsDaoImpl.searchByBBSTitle(text,pageNumber);
		return res;
	}
	
	public List<BbsVo> searchByUserID(int pageNumber,String text){
		List<BbsVo> res= bbsDaoImpl.searchByUserID(text,pageNumber);
		return res;
	}
	
	public List<BbsVo> searchByBBSContent(int pageNumber,String text){
		List<BbsVo> res= bbsDaoImpl.searchByBBSContent(text,pageNumber);
		return res;
	}
	
	public int getNewNext() {
		int res= bbsDaoImpl.getNewNext();
//		Commit(conn);
		return res;
	}
}
