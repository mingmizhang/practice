package com.dp.mingmi;

import org.springframework.stereotype.Repository;

/**
 * Created by zhangmingmi on 17/1/20.
 */
@Repository
public interface IndexMessageDao {
    public IndexMessageDaoImp getIndexMessageVersion();
}
