package com.kit;

import com.kit.collect.MetricsCollector;
import com.kit.collect.RequestInfo;
import com.kit.format.EmailFormat;
import com.kit.format.JsonFormat;
import com.kit.schedule.ConsoleReporter;
import com.kit.schedule.EmailReporter;
import com.kit.schedule.RequestStat;
import com.kit.storage.MemoryStorage;
import com.kit.view.ConsoleViewer;
import com.kit.view.EmailViewer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * Created by kk on 2020/3/29.
 */
public class CollectorTest {
    @Test
    public void collect(){
        MetricsCollector metricsCollector = new MetricsCollector();
        DecimalFormat df = new DecimalFormat(".00");
        while(true){
            RequestInfo requestInfo = new RequestInfo();
            requestInfo.setRecordName("login");
            requestInfo.setStartTimestamp(System.currentTimeMillis());
            BigDecimal time = new BigDecimal(df.format(Math.random()));
            time.setScale(2,BigDecimal.ROUND_FLOOR);
            Double num = Double.parseDouble(time.toString()) * 100;
            String numstr = num.toString().substring(0, num.toString().indexOf("."));
            requestInfo.setResponseTime(Long.parseLong(numstr));
            metricsCollector.putRecord(requestInfo);

            EmailViewer emailViewer = new EmailViewer();
            emailViewer.addToAddress("kk_cnjx@163.com");
            ConsoleViewer consoleViewer = new ConsoleViewer();
            Date date = new Date();
            long startTime = date.getTime();
            ConsoleReporter consoleReporter = new ConsoleReporter(new MemoryStorage(),new JsonFormat<RequestStat>(),emailViewer);
            consoleReporter.startRepeatReport(startTime-60*60*1000,startTime);

            EmailReporter emailReporter = new EmailReporter(new MemoryStorage(),new EmailFormat<RequestStat>(),consoleViewer);
            emailReporter.startRepeatReport(startTime-60*60*1000,startTime);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
