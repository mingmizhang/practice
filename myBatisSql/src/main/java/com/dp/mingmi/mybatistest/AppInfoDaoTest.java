package com.dp.mingmi.mybatistest;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by zhangmingmi on 17/1/23.
 */
@Repository
public class AppInfoDaoTest {
    @Resource(type = AppInfoDao.class)
    private AppInfoDao appInfoDao;

    private String IndexClusterName;
    private String SearchClusterName;
    private String BizClusterName;
    private String appName;
    private int transactionValue=0;

    public String getAddTime() {
        return AddTime;
    }

    public void setAddTime(String addTime) {
        AddTime = addTime;
    }

    private String AddTime;


    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getIndexClusterName() {
        return IndexClusterName;
    }

    public void setIndexClusterName(String indexClusterName) {
        IndexClusterName = indexClusterName;
    }

    public String getSearchClusterName() {
        return SearchClusterName;
    }

    public void setSearchClusterName(String searchClusterName) {
        SearchClusterName = searchClusterName;
    }

    public String getBizClusterName() {
        return BizClusterName;
    }

    public void setBizClusterName(String bizClusterName) {
        BizClusterName = bizClusterName;
    }

    @Override
    public String toString() {
        return "AppInfoDaoTest{" +
                "appInfoDao=" + appInfoDao +
                ", IndexClusterName='" + IndexClusterName + '\'' +
                ", SearchClusterName='" + SearchClusterName + '\'' +
                ", BizClusterName='" + BizClusterName + '\'' +
                ", appName='" + appName + '\'' +
                ", transactionValue=" + transactionValue +
                ", AddTime='" + AddTime + '\'' +
                '}';
    }

    @Transactional("transactionTestManager")
    public void  testTransactionValue(){
        appInfoDao.insertAppName("mainshop");
        //appInfoDao.selectIndexerClusterName("mainshop");
    }
}
