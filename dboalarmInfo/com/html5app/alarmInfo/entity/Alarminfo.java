package com.html5app.alarmInfo.entity;

import java.util.Date;

public class Alarminfo {
    private Long id;
    //����λ��
    private String almposition;
    //������
    private String almpoint;
    //����ʱ��
    private Date almtime;
    //������Ϣ
    private String alminfo;
    //��������
    private Byte almstatus;

    private Byte almclass;
    //����ֵ
    private Float almvalue;

    private Integer almno;

    private String almmono;

    private Byte sendflag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlmposition() {
        return almposition;
    }

    public void setAlmposition(String almposition) {
        this.almposition = almposition == null ? null : almposition.trim();
    }

    public String getAlmpoint() {
        return almpoint;
    }

    public void setAlmpoint(String almpoint) {
        this.almpoint = almpoint == null ? null : almpoint.trim();
    }

    public Date getAlmtime() {
        return almtime;
    }

    public void setAlmtime(Date almtime) {
        this.almtime = almtime;
    }

    public String getAlminfo() {
        return alminfo;
    }

    public void setAlminfo(String alminfo) {
        this.alminfo = alminfo == null ? null : alminfo.trim();
    }

    public Byte getAlmstatus() {
        return almstatus;
    }

    public void setAlmstatus(Byte almstatus) {
        this.almstatus = almstatus;
    }

    public Byte getAlmclass() {
        return almclass;
    }

    public void setAlmclass(Byte almclass) {
        this.almclass = almclass;
    }

    public Float getAlmvalue() {
        return almvalue;
    }

    public void setAlmvalue(Float almvalue) {
        this.almvalue = almvalue;
    }

    public Integer getAlmno() {
        return almno;
    }

    public void setAlmno(Integer almno) {
        this.almno = almno;
    }

    public String getAlmmono() {
        return almmono;
    }

    public void setAlmmono(String almmono) {
        this.almmono = almmono == null ? null : almmono.trim();
    }

    public Byte getSendflag() {
        return sendflag;
    }

    public void setSendflag(Byte sendflag) {
        this.sendflag = sendflag;
    }
}