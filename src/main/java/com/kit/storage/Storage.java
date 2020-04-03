package com.kit.storage;

import com.kit.collect.RequestInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by kk on 2020/3/29.
 */
public interface Storage {

    /**
     * 保存接口访问信息
     * @param requestInfo
     */
    void save(RequestInfo requestInfo);

    /**
     * 查询记录
     * @param startTime
     * @param endTime
     * @return
     */
    List<Record> query(Long startTime, Long endTime);

    /**
     * 数量
     * @param startTime
     * @param endTime
     * @return
     */
    int count(Long startTime, Long endTime);

    /**
     * 最大
     * @param startTime
     * @param endTime
     * @return
     */
    long max(Long startTime, Long endTime);

    /**
     * 最小
     * @param startTime
     * @param endTime
     * @return
     */
    long min(Long startTime, Long endTime);

    /**
     * 平均值
     * @param startTime
     * @param endTime
     * @return
     */
    BigDecimal avg(Long startTime, Long endTime);

}
