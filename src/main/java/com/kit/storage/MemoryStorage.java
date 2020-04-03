package com.kit.storage;

import com.kit.aggregator.Aggregator;
import com.kit.collect.RequestInfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kk on 2020/3/29.
 */
public class MemoryStorage implements Storage {
    private static Map<String,List<Map<String,Long>>> record = new ConcurrentHashMap<String, List<Map<String, Long>>>();
    private final static String START_TIMESTAMP = "START_TIMESTAMP";
    private final static String RESPONSE_TIME = "RESPONSE_TIME";
    private Aggregator aggregator = new Aggregator();

    @Override
    public void save(RequestInfo requestInfo) {
        if (requestInfo==null) return;
        synchronized (requestInfo){
            if (record.get(requestInfo.getRecordName())==null){
                record.put(requestInfo.getRecordName(),new ArrayList<Map<String, Long>>());
            }
            Map<String,Long> recordsMap = new HashMap<String, Long>();
            recordsMap.put(START_TIMESTAMP,requestInfo.getStartTimestamp());
            recordsMap.put(RESPONSE_TIME,requestInfo.getResponseTime());
            List<Map<String, Long>> maps = record.get(requestInfo.getRecordName());
            maps.add(recordsMap);
            record.put(requestInfo.getRecordName(),maps);
        }
    }

    @Override
    public List<Record> query(Long startTime, Long endTime) {
        List<Record> list = new ArrayList<Record>();
        for (Map.Entry<String,List<Map<String,Long>>> item:record.entrySet()){
            for (Map<String,Long> time:item.getValue()) {
                if (time.get(START_TIMESTAMP)>=startTime && time.get(START_TIMESTAMP)<=endTime){
                    Record r = new Record();
                    r.setReocrdName(item.getKey());
                    r.setStartTime(time.get(START_TIMESTAMP));
                    r.setResponseTime(time.get(RESPONSE_TIME));
                    list.add(r);
                }
            }
        }
        return list;
    }

    /**
     * 数量
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public int count(Long startTime, Long endTime) {
        List<Record> list = this.query(startTime, endTime);
        return aggregator.count(list);
    }

    /**
     * 最大
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public long max(Long startTime, Long endTime) {
        List<Record> list = this.query(startTime, endTime);
        return aggregator.max(list);
    }

    /**
     * 最小
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public long min(Long startTime, Long endTime) {
        List<Record> list = this.query(startTime, endTime);
        return aggregator.min(list);
    }

    /**
     * 平均值
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public BigDecimal avg(Long startTime, Long endTime) {
        List<Record> list = this.query(startTime, endTime);
        return aggregator.avg(list);
    }
}
