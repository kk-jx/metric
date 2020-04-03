package com.kit.format;

/**
 * Created by kk on 2020/4/2.
 */
public class EmailFormat<T extends StringType> implements Format<T> {
    @Override
    public String format(T t) throws Exception {
        return "<html><h2 style='float:left'>您好：</h2><h2 style='float:left'>"+t.formatString()+"</h2></html>";
    }
}
