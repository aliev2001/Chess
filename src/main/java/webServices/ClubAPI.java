package webServices;

import repository.ClubRepository;
import repository.interfaces.IClubRepository;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("club")
public class ClubAPI {
    private final IClubRepository clubRepository = new ClubRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addMember/{user_id}/{club_id}")
    public Response addUserToClub(@PathParam("user_id") long userId,@PathParam ("club_id") long clubId){
        try {
            clubRepository.addUserToClub(userId, clubId);
        } catch (ServerErrorException ex){
            return Response
                    .serverError()
                    .entity(ex.getMessage())
                    .build();
        } catch (BadRequestException ex){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(ex.getMessage())
                    .build();
        }
        return Response
                .status(Response.Status.CREATED)
                .entity("User was added to club successfully!")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/removeMember/{user_id}/{club_id}")
    public Response deleteUserFromClub(@PathParam("user_id") long userId,@PathParam ("club_id") long clubId){
        try {
            clubRepository.deleteUserFromClub(userId, clubId);
        } catch (ServerErrorException ex){
            return Response
                    .serverError()
                    .entity(ex.getMessage())
                    .build();
        } catch (BadRequestException ex){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(ex.getMessage())
                    .build();
        }
        return Response
                .status(Response.Status.CREATED)
                .entity("User was deleted from club successfully!")
                .build();
    }

}
