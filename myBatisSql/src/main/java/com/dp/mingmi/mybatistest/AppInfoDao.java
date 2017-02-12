package com.dp.mingmi.mybatistest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangmingmi on 17/1/23.
 */
@Repository("appInfoDao")
public interface AppInfoDao {
    public AppInfoDaoTest getAppClusterName(@Param("AddTime")String AddTime);
    //public AppInfoDaoTest getAppClusterName();
    public void updateIndexerCLusterName(@Param("appIndexer")String appIndexer);
    public String selectIndexerClusterName(String appName);
    public void insertAppName(String appName);
    public void deleteAppName(String appName);
    public List<AppInfoDaoTest> getRelation(@Param("updateTime")String updateTime);
    public List<String> selectIndexerForList(@Param("list")List<String>list);
}
