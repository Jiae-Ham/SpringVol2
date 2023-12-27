package com.example.BCSD.repository;

import com.example.BCSD.DBConnection.DBConnectionManager;
import com.example.BCSD.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class UserMapper {
    public User insertUser(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "insert into User(userId, userName, userPw) values(?, ?, ?)";

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, user.getUserId());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getUserPw());

            statement.executeUpdate();
            return user;
        } catch (SQLException e) {
            log.error("insertUser error={}", e);
            throw e;
        } finally {
            closeResource(connection, statement, null);
        }
    }

    private void closeResource(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        //반환할 때는 반드시 역순으로 반환해야 함.
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                log.error("error", e);
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                log.error("error", e);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                log.error("error", e);
            }
        }
    }

    public List<User> getAllUsers() throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "select * from User";
        List<User> user = new ArrayList<>();

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                user.add(new User(rs.getString("userId"), rs.getString("userName"), rs.getString("userPw")));
            }
            return user;
        }catch (SQLException e) {
            log.error("selection error={}", e);
            throw e;
        } finally {
            closeResource(connection, statement, rs);
        }
    }

    public User getUserByUserId(String userId) throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "select * from User where userId = ?";

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, userId);

            rs = statement.executeQuery();
            User user = new User();
            while (rs.next()) {
                user.setUserId(rs.getString("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserPw(rs.getString("userPw"));
            }
            return user;
        } catch (SQLException e) {
            log.error("selectUser error={}", e);
            throw e;
        } finally {
            closeResource(connection, statement, rs);
        }
    }

    public void updateUserPw(String userId, User user) throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "update User set userPw = ? WHERE userId = ?";//DB에 넘길 SQL 작성
        try {
            connection = DBConnectionManager.getConnection();//DriverManger 통해서 DB커넥션 생성
            statement = connection.prepareStatement(sql);//SQL실행 하기위한 객체 PrepareStatement 생성

            //DB컬럼과 자바 오브젝트 필드 바인딩
            statement.setString(1, user.getUserPw());
            statement.setString(2, userId);
            statement.executeUpdate();

        } catch (SQLException e) {
            log.error("updatePw error={}", e);
            throw e;
        } finally {
            closeResource(connection, statement, null);//사용한 리소스 반환
        }
    }

    public void deleteUser(String userId) throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "delete from User where userId = ?";

        try {
            connection = DBConnectionManager.getConnection();//DriverManger 통해서 DB커넥션 생성
            statement = connection.prepareStatement(sql);//SQL실행 하기위한 객체 PrepareStatement 생성

            statement.setString(1, userId);//DB컬럼과 자바 오브젝트 필드 바인딩

            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("deleteUser error={}", e);
            throw e;
        } finally {
            closeResource(connection, statement, null);//사용한 리소스 반환
        }
    }
}
