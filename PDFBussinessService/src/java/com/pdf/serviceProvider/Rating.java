package com.pdf.serviceProvider;

import com.pdf.businessProcess.ratingProc.RatingConsult;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rating")
public class Rating implements IRating{
    @EJB
    private RatingConsult ratingConsult;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{idActivity}")
    public String activityRating(String idActivity) {
        String rating = ratingConsult.activityRating(Integer.parseInt(idActivity));
        return rating;
    }
}