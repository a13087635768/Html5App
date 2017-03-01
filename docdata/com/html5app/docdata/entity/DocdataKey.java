package com.html5app.docdata.entity;

import java.util.Date;

public class DocdataKey {
    private Date datatime;

    private String doctagname;

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public String getDoctagname() {
        return doctagname;
    }

    public void setDoctagname(String doctagname) {
        this.doctagname = doctagname == null ? null : doctagname.trim();
    }
}