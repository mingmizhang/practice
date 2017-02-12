package com.dp.mingmi;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhangmingmi on 17/1/20.
 */
public class Bootstrap {
    public static void main(String[] args){
//        ApplicationContext springCtx = new ClassPathXmlApplicationContext("spring-context.xml");
//        DatabaseQueryService dbQueryService = (DatabaseQueryService) springCtx.getBean("dbQueryService");
//        dbQueryService.connectMysql();
        testMybatis();
        try {
            //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
            String resource = "mybatis.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //构建sqlSession的工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            String statement = "com.dp.mingmi.IndexMessageDao.getIndexMessageVersion";//映射sql的标识字符串
            //执行查询返回一个唯一对象的sql
            IndexMessageDaoImp indexMessageDaoImp = session.selectOne(statement);
            System.out.println(indexMessageDaoImp);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void testMybatis(){
        ApplicationContext springCtx = new ClassPathXmlApplicationContext("spring-context.xml");
        IndexMessageDao dao = (IndexMessageDao) springCtx.getBean("indexMessageDao");
        IndexMessageDaoImp indexMessageDaoImp = dao.getIndexMessageVersion();
        System.out.println(indexMessageDaoImp);

    }

}
