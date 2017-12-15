package org.jmotor.restlet;

import org.jmotor.model.TeamMemberDataBase;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import java.util.Arrays;
import java.util.List;

/**
 * StacksRestlet is the RestAPI interface.
 * 
 * Statistics generation in Team's member database :
 * Periodically, each TeamMemberDataBase entry process stores statistics 
 * counters in the database 
 * 
 * Statistics extraction from database :
 * Periodically, a user can extract statistics reports from the database. 
 * For a selected team name key, the extraction is the result of stored in the 
 * database.
 * 
 * @author zhuhui
 * @createDate 2017-12-13
 */
@Path("v1/neo/hackathon/IN")
public class TeamMemberDataBaseRestlet {
    @GET
    @Produces("application/json")
    public List<TeamMemberDataBase> getAllTeamMember() 
	{
        return Arrays.asList(
                TeamMemberDataBase.Builder.newBuilder().id(1).vsName("ISDK VStream").groupName("Flash ScreamTeam").memberName("Zhu Hui").memberId("61455265").build(),
                TeamMemberDataBase.Builder.newBuilder().id(2).vsName("NE3S-WS VStream").groupName("Halo ScreamTeam").memberName("Larry Liu").memberId("61465322").build()
        );
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public TeamMemberDataBase getSinglTeamMember(@NotNull @PathParam("id") Integer id) 
	{
        switch (id) {
            case 1:
                return TeamMemberDataBase.Builder.newBuilder().id(1).vsName("ISDK VStream").groupName("Flash ScreamTeam").memberName("Zhu Hui").memberId("61455265").build();
            case 2:
                return TeamMemberDataBase.Builder.newBuilder().id(2).vsName("NE3S-WS VStream").groupName("Halo ScreamTeam").memberName("Larry Liu").memberId("61465322").build();
            default:
                throw new WebApplicationException("NEO Hackathon I.N Team do not have the according member, id: " + id, 404);
        }
    }
}
