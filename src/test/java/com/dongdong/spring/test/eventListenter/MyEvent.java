package com.dongdong.spring.test.eventListenter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Date: 2019/12/20  18:08
 * @Author: dongdong
 */
public class MyEvent  implements  Event{
    private Log log = LogFactory.getLog(getClass());

    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private Object source;

    private Date when;
    private String message;
    @Override
    public Object getSource() {
        return source;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Date getWhen() {
        return when;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void callback() {
      log.info(toString());
    }

    @Override
    public String  toString(){
        return "source"+getSource()+",message"+getMessage()+",when"+sdf.format(getWhen());
    }

}
