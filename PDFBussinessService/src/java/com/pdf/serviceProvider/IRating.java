package com.pdf.serviceProvider;

import javax.ws.rs.PathParam;

public interface IRating {
    public String getRate(@PathParam("idactivity") String idactivity);
    public void rateActivity(@PathParam("idactivity") String idactivity, @PathParam("mark") String mark);
}