package com.pdf.businessServices.rating;

public interface IRatable {
    public String getRate(int idActivity);
    public void rateActivity(int idActivity, double mark);
}
