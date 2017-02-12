package com.dp.mingmi;

/**
 * Created by zhangmingmi on 17/1/20.
 */
public class SpringSqlTest {
    private String driver;
    private String username;
    private String ip;
    private String port;
    private String databasename;
    private String passwd;
    private String sql;
    private String url;

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setDatabasename(String databasename) {
        this.databasename = databasename;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public void setUrl(String url) {
        this.url = String.format("jdbc:mysql://%s:%s/%s", ip, port, databasename);
    }

    public String getDriver() {
        return driver;
    }

    public String getUsername() {
        return username;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public String getDatabasename() {
        return databasename;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getSql() {
        return sql;
    }

    public String getUrl() {
        return url;
    }

}
