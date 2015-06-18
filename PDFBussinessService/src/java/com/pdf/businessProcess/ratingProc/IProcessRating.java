package com.pdf.businessProcess.ratingProc;

public interface IProcessRating {
    public String getRate(int idActivity);
    public void rateActivity(int idActivity, double mark);
}
