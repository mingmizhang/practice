package com.dp.mingmi.mybatistest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangmingmi on 17/1/23.
 */
public class BatisTest {
    public static void main(String[] args){
        testBatis();

    }
    public static void testBatis(){
        ApplicationContext spingText=new ClassPathXmlApplicationContext("batis-spring.xml");
        //用全限列名或者是class
        AppInfoDao appInfoDao = (AppInfoDao) spingText.getBean(AppInfoDao.class);
       AppInfoDaoTest appInfoDaoTest=appInfoDao.getAppClusterName("2014-11-12 00:00:00");
//        System.out.println(appInfoDaoTest);
//        List<AppInfoDaoTest> appInfoDaoTestList=appInfoDao.getRelation("2016-02-06 17:58:36");
//        for(int i=0;i<appInfoDaoTestList.size();i++) {
//            System.out.println(appInfoDaoTestList.get(i).getAppName());
//        }
        List<String> testList = new ArrayList<String>();
        testList.add("shop");
        testList.add("arts_it");
        System.out.println(testList);
        List<String> indexerNameList=appInfoDao.selectIndexerForList(testList);
        for(int i=0;i<indexerNameList.size();i++) {
            System.out.println(indexerNameList.get(i));
        }


//        appInfoDao.updateIndexerCLusterName("shop_indexer");
//        System.out.println(appInfoDao.selectIndexerClusterName("arts_it"));
//        appInfoDao.insertAppName("mainshop");
//        System.out.println(appInfoDao.selectIndexerClusterName("mainshop"));
//        appInfoDao.deleteAppName("mainshop");
//        AppInfoDao appInfoDao=spingText.getBean(AppInfoDao.class);
//        if(appInfoDao!=null){
//            System.out.println("appInfoDao");
//        }
//        AppInfoDaoTest appInfoDaoTest=spingText.getBean(AppInfoDaoTest.class);
//        appInfoDaoTest.testTransactionValue();
//
//        FacadeDao facadeDao = spingText.getBean(FacadeDao.class);
//        if(facadeDao.getAppInfoDao()!=null){
//            System.out.println("facadeDao");
//        }

    }
}
