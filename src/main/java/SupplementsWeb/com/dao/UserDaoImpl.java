package SupplementsWeb.com.dao;


import SupplementsWeb.com.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{



    public class UserRowMapper implements RowMapper<UserVo>{

        @Override
        public UserVo mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserVo entity = new UserVo();
            entity.setUserID(rs.getString(1));
            entity.setUserPassword(rs.getString(2));
            entity.setUserName(rs.getString(3));
            entity.setUserGender(rs.getString(4));
            entity.setUserEmail(rs.getString(5));
            entity.setUserBirth(rs.getString(6));
            return entity;
        }

    }
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;

    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


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


    public String checkLoginUser(String userID) {
        System.out.println("임플에서 id는 잘 넘어오니? " + userID);
//        RowMapper<UserVo> rowMapper = (rs, rowNum) -> {
//            UserVo entity = new UserVo();
//            entity.setUserID(rs.getString(1));
//            entity.setUserPassword(rs.getString(2));
//            entity.setUserName(rs.getString(3));
//            entity.setUserGender(rs.getString(4));
//            entity.setUserEmail(rs.getString(5));
//            entity.setUserBirth(rs.getString(6));
//            return entity;
//        };

        RowMapper<UserVo> mapper = new UserRowMapper() {
            @Override
            public UserVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserVo entity = new UserVo();
                entity.setUserID(rs.getString(1));
                entity.setUserPassword(rs.getString(2));
                entity.setUserName(rs.getString(3));
                entity.setUserGender(rs.getString(4));
                entity.setUserEmail(rs.getString(5));
                entity.setUserBirth(rs.getString(6));
                return entity;
            }
        };
        System.out.println(jdbcTemplate);

//        return jdbcTemplate.queryForObject(checkLoginUser, mapper, new Object[] {userID});

        return jdbcTemplate.queryForObject(checkLoginUser,
                new Object[] {userID},  new int[] { java.sql.Types.VARCHAR}, String.class);


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