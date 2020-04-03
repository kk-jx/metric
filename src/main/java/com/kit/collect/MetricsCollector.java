package com.kit.collect;

import com.kit.storage.MemoryStorage;
import com.kit.storage.RequestQueue;
import com.kit.storage.Storage;

/**
 * Created by kk on 2020/3/29.
 */
public class MetricsCollector {
    private RequestQueue queue;
    private Storage storage = new MemoryStorage();

    public MetricsCollector() {
        this.queue = new RequestQueue(storage);
    }
    public MetricsCollector(Storage storage) {
        this.storage = storage;
        this.queue = new RequestQueue(storage);
    }

    public void putRecord(RequestInfo requestInfo){
        queue.put(requestInfo);
    }


}
