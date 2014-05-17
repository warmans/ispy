package ispy.api.v1.resource;
import ispy.api.v1.Result;

import ispy.guesser.Guesser;
import ispy.guesser.Something;
import ispy.guesser.Guess;

import java.lang.InternalError;
import java.lang.RuntimeException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/i-spy-with-my-little-eye-something-beginning-with")
@Produces({"application/json"})
public class SpyResource
{
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result getGuess(Something something)
    {
        try {
            //how does DI work in Jersy?!
            Connection db = DriverManager.getConnection("jdbc:sqlite:things.sqlite");
            Guesser guesser = new Guesser(db);
            return new Result(true, guesser.guess(something).getThing());
        } catch (Exception e) {
            return new Result(false, "", e.getMessage());
        }
    }
}
