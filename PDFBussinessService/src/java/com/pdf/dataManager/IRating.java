package com.pdf.dataManager;

public interface IRating {
    public String getRate(int idActivity);
    public void rateActivity(int idActivity, double mark);
}
