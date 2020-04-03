package com.kit.aggregator;

import com.kit.storage.Record;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kk on 2020/3/30.
 */
public class Aggregator {

    public int count(List<Record> list){
        return list.size();
    }

    public Long max(List<Record> list){
        Long max = 0L;
        for (Record r:list) {
            if (r.getResponseTime() > max){
                max = r.getResponseTime();
            }
        }
        return max;
    }

    public Long min(List<Record> list){
        if (list==null || list.isEmpty()){
            return 0L;
        }
        Long min = list.get(0).getResponseTime();
        for (Record r:list) {
            if (r.getResponseTime() < min){
                min = r.getResponseTime();
            }
        }
        return min;
    }

    public BigDecimal avg(List<Record> list){
        int count = count(list);
        Long sum = 0L;
        for (Record r:list) {
            sum += r.getResponseTime();
        }
        if (count>0){
            float f = sum/count;
            BigDecimal v = new BigDecimal(f);
            v.setScale(2,BigDecimal.ROUND_HALF_UP);//四舍五入
            return v;
        }
        return new BigDecimal(0.00);
    }


}
