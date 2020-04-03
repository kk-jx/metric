package com.kit.collect;

/**
 * Created by kk on 2020/3/29.
 */
public class RequestInfo {

    private String recordName;

    private Long startTimestamp;

    private Long responseTime;

    public RequestInfo() {
    }

    public RequestInfo(String recordName, Long startTimestamp, Long responseTime) {
        this.recordName = recordName;
        this.startTimestamp = startTimestamp;
        this.responseTime = responseTime;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public Long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }
}
