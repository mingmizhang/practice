package com.dp.mingmi;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by zhangmingmi on 16/9/29.
 */
public class DateProcess {
    private String date;

    public DateProcess(String date) {
        this.date = date;
    }

    public List<String> resolveDate() {
        List<String> dateResolveValue = Lists.newArrayList();
        int beginDate;
        int endDate;
        if (date.contains("~")) {
            beginDate = Integer.valueOf(StringUtils.split(date, "~")[0]);
            endDate = Integer.valueOf(StringUtils.split(date, "~")[1]);
            for (int i = beginDate; i < endDate + 1; ) {
                dateResolveValue.add(String.valueOf(i));
                switch (i) {
                    case 131:
                        i = 201;
                        break;
                    case 229:
                        i = 301;
                        break;
                    case 331:
                        i = 401;
                        break;
                    case 430:
                        i = 501;
                        break;
                    case 531:
                        i = 601;
                        break;
                    case 630:
                        i = 701;
                        break;
                    case 731:
                        i = 801;
                        break;
                    case 831:
                        i = 901;
                        break;
                    case 930:
                        i = 1001;
                        break;
                    case 1031:
                        i = 1101;
                        break;
                    case 1130:
                        i = 1201;
                        break;
                    default:
                        i = i + 1;
                }
            }

        } else {
            dateResolveValue.add(date);

        }
        return dateResolveValue;

    }
}
