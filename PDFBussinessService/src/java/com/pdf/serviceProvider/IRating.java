package com.pdf.serviceProvider;

import javax.ws.rs.PathParam;

public interface IRating {
    public String activityRating(@PathParam("idActivity") String idActivity);
}