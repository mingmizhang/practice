package com.dp.mingmi;

import java.sql.*;

/**
 * Created by zhangmingmi on 17/1/19.
 */
public class MySqlTest {
    public static void main(String[] args) {
        MySqlTest mySqlTest = new MySqlTest();
        mySqlTest.connectMysql();
    }

    public void connectMysql() {
        //加载数据库驱动类
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            String userName = "xxx";
            String passwd = "xxx";
            String ip = "xxx";
            String port = "xxx";
            String databasename = "xxx";
            String url = "jdbc:mysql//" + ip + ":" + port + "/" + databasename;
            System.out.println(url);
            String jdbcUrl = String.format("jdbc:mysql://%s:%s/%s", ip, port, databasename);
            System.out.println(jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, userName, passwd);
            String sql = "select * from Arts_IndexMessage where AppName=\"arts_it\" order by AddTime desc limit 10";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            //获取列名或者列的个数
            ResultSetMetaData rd=resultSet.getMetaData();
            int columnNum=rd.getColumnCount();
            System.out.println(columnNum);
            while(resultSet.next()){
                String indexVersion=resultSet.getString(4);
                System.out.println(indexVersion);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
