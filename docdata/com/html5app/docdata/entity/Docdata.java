package com.html5app.docdata.entity;

public class Docdata extends DocdataKey {
    private Float docvalue;

    private Integer docdeldate;

    private Short doccount;

    private Byte sendflag;

    public Float getDocvalue() {
        return docvalue;
    }

    public void setDocvalue(Float docvalue) {
        this.docvalue = docvalue;
    }

    public Integer getDocdeldate() {
        return docdeldate;
    }

    public void setDocdeldate(Integer docdeldate) {
        this.docdeldate = docdeldate;
    }

    public Short getDoccount() {
        return doccount;
    }

    public void setDoccount(Short doccount) {
        this.doccount = doccount;
    }

    public Byte getSendflag() {
        return sendflag;
    }

    public void setSendflag(Byte sendflag) {
        this.sendflag = sendflag;
    }
}