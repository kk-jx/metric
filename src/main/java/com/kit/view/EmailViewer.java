package com.kit.view;

import com.kit.format.Format;
import com.kit.format.StringType;
import com.kit.utils.SendMailUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kk on 2020/4/2.
 */
public class EmailViewer implements Viewer {

    private List<String> toAddress = new ArrayList<String>();
    private String title = "消息提醒";

    public void addToAddress(String address){
        toAddress.add(address);
    }

    public void addToAddress(List<String> address){
        toAddress.addAll(address);
    }

    public void setEmailTitle(String title){
        this.title = title;
    }

    @Override
    public void output(Format fm, StringType result) {
        try {
            for (String address:toAddress) {
                //发送邮件
                SendMailUtil.sendMail(address,fm.format(result),title);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
