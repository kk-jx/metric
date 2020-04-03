package com.kit.storage;

/**
 * Created by kk on 2020/3/30.
 */
public class Record {

    private String reocrdName;
    private Long startTime;
    private Long responseTime;

    public String getReocrdName() {
        return reocrdName;
    }

    public void setReocrdName(String reocrdName) {
        this.reocrdName = reocrdName;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }
}
