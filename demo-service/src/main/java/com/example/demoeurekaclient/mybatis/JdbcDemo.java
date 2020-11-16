package com.example.demoeurekaclient.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.demoeurekaclient.entry.ItemObject;

/**
 * @author zhanglirui
 * @date 2020/11/12 5:05 下午
 */
public class JdbcDemo {

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/dbzhang";
            String user = "zhangroot";
            String password = "1qaz2wsx";
            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ItemObject getRole(Long id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("select * from dbzhang_userinfo where id = ?");
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Long roleId = rs.getLong("id");
                String userName = rs.getString("name");
                String realname = rs.getString("nick");
                ItemObject itemObject = new ItemObject();
                itemObject.setId(roleId);
                itemObject.setName(userName);
                itemObject.setNick(realname);
                return itemObject;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            ps.close();
            rs.close();
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        JdbcDemo jdbcDemo = new JdbcDemo();
        ItemObject demoRole = jdbcDemo.getRole(1L);
        System.out.println(demoRole);
    }

}
