package com.kit.schedule;

import com.kit.storage.Storage;

/**
 * Created by kk on 2020/4/3.
 */
public abstract class Reporter {

    public RequestStat findReport(Storage storage, Long startTime, Long endTime){
        RequestStat requestStat = new RequestStat();
        requestStat.setMax(storage.max(startTime, endTime));
        requestStat.setMin(storage.min(startTime, endTime));
        requestStat.setAvg(storage.avg(startTime, endTime));
        requestStat.setCount(storage.count(startTime, endTime));
        return requestStat;
    }

}
