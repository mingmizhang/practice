package com.dp.mingmi.fileoperation;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by zhangmingmi on 16/9/19.
 */
public class LsDirCommand implements Command {
    private DirExtract dirExtract;

    public LsDirCommand(DirExtract dirExtract) {
        this.dirExtract = dirExtract;
    }
    public StringWriter excute() throws IOException {
        return dirExtract.lsDir();
    }
    
}
