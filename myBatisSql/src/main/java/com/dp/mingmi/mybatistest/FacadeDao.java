package com.dp.mingmi.mybatistest;

import javax.annotation.Resource;

/**
 * Created by zhangmingmi on 17/1/24.
 */
public class FacadeDao {
    @Resource(type= AppInfoDao.class)
    private AppInfoDao appInfoDao;

    public AppInfoDao getAppInfoDao() {
        return appInfoDao;
    }

    public void setAppInfoDao(AppInfoDao appInfoDao) {
        this.appInfoDao = appInfoDao;
    }
}
