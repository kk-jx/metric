package com.kit.schedule;

import com.kit.format.Format;
import com.kit.format.JsonFormat;
import com.kit.storage.MemoryStorage;
import com.kit.storage.Storage;
import com.kit.view.ConsoleViewer;
import com.kit.view.Viewer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kk on 2020/4/3.
 */
public class EmailReporter extends Reporter {
    private Storage storage = new MemoryStorage();
    private Viewer viewer = new ConsoleViewer();
    private Format<RequestStat> dataFormat = new JsonFormat<RequestStat>();

    public EmailReporter(Storage storage, Format<RequestStat> dataFormat, Viewer viewer) {
        this.storage = storage;
        this.dataFormat = dataFormat;
        this.viewer = viewer;
    }

    public void startRepeatReport(Long startTime,Long endTime){
        RequestStat requestStat = findReport(storage, startTime, endTime);
        viewer.output(dataFormat,requestStat);
    }


}
