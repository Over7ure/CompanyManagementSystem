package com.model;

import java.io.Serializable;

public class Attendance implements Serializable {
    private int pno;
    private int need;
    private int fact;

    public Attendance() {
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public int getFact() {
        return fact;
    }

    public void setFact(int fact) {
        this.fact = fact;
    }

    public int getNeed() {
        return need;
    }

    public void setNeed(int need) {
        this.need = need;
    }
}
