package com.pdf.serviceProvider;

import com.pdf.businessProcess.ratingProc.RatingConsult;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rating")
public class Rating implements IRating{
    @EJB
    private RatingConsult ratingConsult;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{idactivity}")
    public String getRate(@PathParam("idactivity") String idactivity) {
        String rating = ratingConsult.getRate(Integer.valueOf(idactivity));
        return rating;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{idactivity}/{mark}")
    public void rateActivity(@PathParam("idactivity")String idactivity, @PathParam("mark") String mark) {
        ratingConsult.rateActivity(Integer.valueOf(idactivity), Double.valueOf(mark));
    }
}