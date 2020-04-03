package com.kit.view;

import com.kit.format.Format;
import com.kit.format.StringType;

/**
 * Created by kk on 2020/4/2.
 */
public class ConsoleViewer implements Viewer {

    @Override
    public void output(Format fm, StringType result) {
        try {
            System.out.println(fm.format(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
