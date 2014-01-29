package epsi.talkative.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import epsi.talkative.bean.Comment;

public class ArticlesResource {

        @GET
        @Path("{article: .+}/comments")
        public Response getComments(@PathParam("article") @Encoded String article) {
                return Response.noContent().header("Link", "http://" + article + "; rel=\"article\"").build();
        }
        
        @PUT
        @Path("{article: .+}")
        @Consumes({"application/xml", "application/json"})
    	@Produces({"application/xml", "application/json"})
    	public Response put(Comment com){
        	com.setTimestamp(System.currentTimeMillis());
        	if(com.getContenu().isEmpty() || com.getMail().isEmpty() || com.getPseudo().isEmpty())
        		return Response.status(400).entity(com).build();
        	else
        		return Response.status(201).entity(com).build();
    	}
}