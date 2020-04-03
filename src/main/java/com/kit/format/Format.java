package com.kit.format;


/**
 * Created by kk on 2020/4/2.
 */
public interface Format<T extends StringType> {

    String format(T t) throws Exception;

}
