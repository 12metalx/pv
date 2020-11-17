package dao;

import entities.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static String SQL_SELECT = "select * from user where userNameUser = ?";
    private static String SQL_SHA = "select sha2(?,256)";
    private Connection connection = null;

    private void getConnection() {
        String usr = "root";
        String pwd = "root";
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/pv?allowPublicKeyRetrieval=true&serverTimezone=America/Mexico_City&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, usr, pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List getResults(ResultSet rs) {
        List results = new ArrayList();
        User u = new User();
        try {
            while (rs.next()) {
                u.setId(rs.getInt("idUser"));
                u.setUserName(rs.getString("userNameUser"));
                u.setPass(rs.getString("passUser"));
                u.setRol(rs.getInt("rolUser"));
                results.add(u);
            }
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public User read(String user) throws SQLException {
        getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List results = null;
        try {
            ps = connection.prepareStatement(SQL_SELECT);
            ps.setString(1, user);
            rs = ps.executeQuery();
            results = getResults(rs);
            if (results.size() > 0) {
                return (User) results.get(0);
            } else {
                return null;
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }

        }

    }

    public String getHash(String pass) throws SQLException {
        getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(SQL_SHA);
            ps.setString(1, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

}
