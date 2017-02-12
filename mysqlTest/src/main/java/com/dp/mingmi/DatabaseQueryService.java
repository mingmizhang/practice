package com.dp.mingmi;

import java.sql.*;

/**
 * Created by zhangmingmi on 17/1/20.
 */
public class DatabaseQueryService {

    private SpringSqlTest springSqlTest;

    public void setSpringSqlTest(SpringSqlTest springSqlTest) {
        this.springSqlTest = springSqlTest;
    }

    public void connectMysql() {
        //加载数据库驱动类
        try {
            Class.forName(springSqlTest.getDriver());
            //连接数据库
            Connection connection = DriverManager.getConnection(springSqlTest.getUrl(), springSqlTest.getUsername(),springSqlTest.getPasswd());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Arts_IndexMessage where AppName=\"arts_it\" order by AddTime desc limit 10");
            while (resultSet.next()) {
                String indexVersion = resultSet.getString(4);
                System.out.println(indexVersion);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
