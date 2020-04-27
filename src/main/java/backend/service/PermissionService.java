package backend.service;

import backend.db.Broker;
import backend.db.ConnectionManager;

import javax.naming.NamingException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;

@Path("service")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON )
public class PermissionService {



    /*@POST
    @Path("/addSamisClientApp/{LimitOfRequests}/{FirstDigitIndicator}/{InitialValue}")
    public String AddSamisClientApp(@PathParam("LimitOfRequests") int LimitOfRequests, @PathParam("FirstDigitIndicator") int FirstDigitIndicator,
                                    @PathParam("InitialValue") long initVal) throws Exception {

        return "";
    }*/


    @POST
    @Path("/getUserData")
    public Response getUsers(
            @QueryParam("id") long id ) throws SQLException, NamingException {

        try {

            return Response
                    .status(200)
                    .entity(""+Broker.getPermission(ConnectionManager.getFullStopConnection(),id)).build();


        } catch (SQLException e) {
            throw e ;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }



    }

    @POST
    @Path("/setUserData")
    public Response setUserData (
            @QueryParam("id") long id,
            @QueryParam("isPermanent") boolean isPermanent,
            @QueryParam("reason") String reason,
            @QueryParam("date1") String date1,
            @QueryParam("date2") String date2,
            @QueryParam("place") String place,
            @QueryParam("attached") String attached) throws SQLException, NamingException, ParseException {

        boolean needRevision = false;

        //some code about needRevision

            Broker.setPossiblePemission(ConnectionManager.getFullStopConnection(),id,isPermanent,reason,place,date1,date2,attached ,needRevision);




        return Response
                .status(200)
                .entity("responce"+true).build();
    }

    @GET
    @Path("/print")
    public Response print(
            @QueryParam("id") long id ) {

            System.out.println(" print works "+ id);
            return Response
                    .status(200)
                    .entity("print "+id).build();



    }

}
