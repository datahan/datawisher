package com.example.jxls.domain;

public class Settlement {

    private String batchNo;

    private String transNo;

    public Settlement(String batchNo, String transNo) {
        this.batchNo = batchNo;
        this.transNo = transNo;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }
}
