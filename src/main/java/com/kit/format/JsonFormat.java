package com.kit.format;

import com.alibaba.fastjson.JSON;

/**
 * Created by kk on 2020/4/2.
 */
public class JsonFormat<T extends StringType> implements Format<T> {
    @Override
    public String format(T t) throws Exception {
        return JSON.toJSONString(t);
    }
}
