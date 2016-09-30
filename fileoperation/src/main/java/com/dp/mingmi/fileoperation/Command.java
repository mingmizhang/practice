package com.dp.mingmi.fileoperation;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by zhangmingmi on 16/9/19.
 */
public interface Command {
    StringWriter excute() throws IOException;
}
