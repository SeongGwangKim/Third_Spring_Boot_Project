package SupplementsWeb.com.dao;


import SupplementsWeb.com.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserVo getUser(String userID) {
        RowMapper<UserVo> rowMapper = (rs, rowNum) -> {
            UserVo entity = new UserVo();
            entity.setUserID(rs.getString(1));
            entity.setUserPassword(rs.getString(2));
            entity.setUserName(rs.getString(3));
            entity.setUserGender(rs.getString(4));
            entity.setUserEmail(rs.getString(5));
            entity.setUserBirth(rs.getString(6));
            return entity;
        };

        return jdbcTemplate.queryForObject(getUser,
                new Object[] {userID}, rowMapper);

    }


    public UserVo checkLoginUser(UserVo userVo) {
        RowMapper<UserVo> rowMapper = (rs, rowNum) -> {
            UserVo entity = new UserVo();
            entity.setUserID(rs.getString(1));
            entity.setUserPassword(rs.getString(2));
            entity.setUserName(rs.getString(3));
            entity.setUserGender(rs.getString(4));
            entity.setUserEmail(rs.getString(5));
            entity.setUserBirth(rs.getString(6));
            return entity;
        };

        return jdbcTemplate.queryForObject(getUser,
                new Object[] {userVo.getUserID()}, rowMapper);

    }
    public int joinUser(UserVo vo) {
        return jdbcTemplate.update(joinUser,
                new Object[]{vo.getUserID(), vo.getUserPassword(), vo.getUserName(),
                        vo.getUserGender(), vo.getUserEmail(), vo.getUserBirth()});

    }


    public int deleteUser(String userID) {
        return jdbcTemplate.update(deleteUser, new Object[]{userID});

    }

    public int updatePassword(String userID, String userPassword) {
        return jdbcTemplate.update(updatePassword, new Object[]{userPassword, userID});

    }


    public int updateEmail(String userID, String userEmail) {
        return jdbcTemplate.update(updateEmail, new Object[]{userEmail, userID});

    }
}