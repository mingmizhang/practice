package com.dp.mingmi;

/**
 * Created by zhangmingmi on 17/1/20.
 */
public class IndexMessageDaoImp  {
    public void setIndexMessageVersion(String indexMessageVersion) {
        this.indexMessageVersion = indexMessageVersion;
    }

    public String getIndexMessageVersion() {
        return indexMessageVersion;
    }

    private String indexMessageVersion;

    public void printIndexmessageVersion(){
        System.out.println(indexMessageVersion);

    }

    @Override
    public String toString() {
        return "IndexMessageDaoImp{" +
                "indexMessageVersion='" + indexMessageVersion + '\'' +
                '}';
    }
}
