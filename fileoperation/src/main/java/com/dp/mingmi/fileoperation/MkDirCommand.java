package com.dp.mingmi.fileoperation;

import java.io.StringWriter;

/**
 * Created by zhangmingmi on 16/9/19.
 */
public class MkDirCommand implements Command {
    private DirExtract dirExtract;

    public MkDirCommand(DirExtract dirExtract) {
        this.dirExtract = dirExtract;
    }
    public StringWriter excute() {
        return dirExtract.mkDir();
    }
}
