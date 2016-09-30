package com.dp.mingmi.fileoperation;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangmingmi on 16/9/19.
 */
public class FileOperateTest {
    private Command cmd;
    private DirExtract dirExtract;
    private String expression;
    private static final Logger logger = LoggerFactory.getLogger(FileOperateTest.class);
    private StringWriter stringWriter = new StringWriter();
    public FileOperateTest(String expression) {
        this.expression = expression;
    }

    //

    public StringWriter runCmd() throws IOException {
        String[] cmdList = StringUtils.split(expression, '|');
        for (int i = 0; i < cmdList.length; i++) {
            dirExtract = new DirExtract(cmdList[i],stringWriter);
            if (cmdList[i].contains("ls")) {
                cmd = new LsDirCommand(dirExtract);
                stringWriter = cmd.excute();
            } else if (cmdList[i].contains("mkdir")) {
                cmd = new MkDirCommand(dirExtract);
                stringWriter = cmd.excute();
            } else if (cmdList[i].contains("cd")) {
                cmd = new CdDirCommand(dirExtract);
                stringWriter = cmd.excute();
            } else if (cmdList[i].contains("show")) {
                cmd = new ShowDiretoryWithDot(dirExtract);
                stringWriter = cmd.excute();
            }
        }
        return stringWriter;
    }

    //

    public StringWriter runCmdRecurse() throws IOException {

        return runBase(expression,stringWriter);
    }

    public StringWriter runBase(String exlist,StringWriter stringWriter) throws IOException {
        dirExtract = new DirExtract(exlist,stringWriter);
        if(exlist.contains("|")){
            stringWriter = process(exlist.substring(0,exlist.indexOf('|')),stringWriter);
            exlist = exlist.substring(exlist.indexOf('|') + 1, exlist.length());
            return runBase(exlist,stringWriter);
        }else {
            return process(exlist,stringWriter);
        }
    }

    private StringWriter process(String exlist,StringWriter stringWriter)  {

        dirExtract = new DirExtract(exlist,stringWriter);
        try {
            if (exlist.contains("ls")) {
                cmd = new LsDirCommand(dirExtract);
                stringWriter = cmd.excute();
            } else if (exlist.contains("mkdir")) {
                cmd = new MkDirCommand(dirExtract);
                stringWriter = cmd.excute();
            } else if (exlist.contains("cd")) {
                cmd = new CdDirCommand(dirExtract);
                stringWriter = cmd.excute();
            } else if (exlist.contains("show")) {
                cmd = new ShowDiretoryWithDot(dirExtract);
                stringWriter = cmd.excute();
            }
        }catch (IOException e){
            logger.info("我最美~", e);
        }
        String love = "";
        logger.info(love);
        return stringWriter;
    }

    public static void main(String[] args) throws IOException {
        //FileOperateTest fileOperateTest = new FileOperateTest("show /Users/zhangmingmi/../zhangmingmi/Desktop/../Desktop/code_project");
        //FileOperateTest fileOperateTest = new FileOperateTest("show /Users/zhangmingmi/../zhangmingmi/Desktop/../Desktop/code_project|ls /Users/zhangmingmi/../zhangmingmi/Desktop/../Desktop/code_project/java-practise");
        //FileOperateTest fileOperateTest = new FileOperateTest("cd /Users/zhangmingmi/../zhangmingmi/Desktop/../Desktop/code_project/|ls /Users/zhangmingmi/Desktop/code_project");
        FileOperateTest fileOperateTest = new FileOperateTest("show /Users/zhangmingmi/../zhangmingmi/Desktop/../Desktop/|ls /Users/zhangmingmi/|cd /Users/zhangmingmi/../zhangmingmi/Desktop/../Desktop/code_project/test| ls /Users/zhangmingmi/Desktop/code_project");
        //StringWriter stringWriter =fileOperateTest.runCmd();
        StringWriter stringWriter = fileOperateTest.runCmdRecurse();
        System.out.print(stringWriter.toString());
        List<String> hah = new ArrayList<String>();
        hah.add("SD");
        hah.add("po");
        logger.info(" {} v asda",hah);


        List<String> sb = new ArrayList<String>();
        List<String> sb1 = Lists.newArrayList();
        System.out.println(hah);
    }


    //String expression = "   ls       /Users/zhangmingmi/.././zhangmingmi/Desktop/../";
//        String expression = "   mkdir       /Users/zhangmingmi/Desktop/test";
//        DirExtract dirExtract = new DirExtract(expression);
//        //test show dir with dot
//        Command showDiretoryWithDot =  new ShowDiretoryWithDot(dirExtract);
//        String showResult = showDiretoryWithDot.excute();
//        System.out.println(showResult);
//
//        //test ls dir
//        Command lsDirCommand = new LsDirCommand(dirExtract);
//        String lsResult =lsDirCommand.excute();
//        System.out.println(lsResult);
//
//        //test cd dir
//        Command cdDirCommand = new CdDirCommand(dirExtract);
//        String cdResult =cdDirCommand.excute();
//        System.out.println(cdResult);
//
//        //test make dir
//        Command mkDirCommand = new MkDirCommand(dirExtract);
//        String mkResult =mkDirCommand.excute();
//        System.out.println(mkResult);
}
