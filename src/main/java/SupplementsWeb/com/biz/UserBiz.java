package SupplementsWeb.com.biz;

import SupplementsWeb.com.dao.UserDaoImpl;
import SupplementsWeb.com.vo.UserVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserBiz {
	
	@Autowired
	private static UserDaoImpl userDaoImpl;


    public UserVo getUser(String userID) {
        UserVo res= userDaoImpl.getUser(userID);
        return res;
    }
    
    public String checkLoginUser(String userID) {
//        UserDaoImpl userDaoImpl = new UserDaoImpl();

        System.out.println("userID? " + userID);
        String res= userDaoImpl.checkLoginUser(userID);
        System.out.println("Biz니? " + res);
        return res;
    }
    
    public int joinUser(UserVo vo) {
        int res= userDaoImpl.joinUser(vo);
        return res;
    }
    
    public int deleteUser(String userID) {
        int res= userDaoImpl.deleteUser(userID);
        return res;
    }
    
    public int updatePassword(String userID, String userPassword) {
        int res= userDaoImpl.updatePassword(userID, userPassword);
//        Commit(conn);
        return res;
    }
    
    public int updateEmail(String userID, String userEmail) {
        int res= userDaoImpl.updateEmail(userID, userEmail);
//        Commit(conn);
        return res;
    }
}