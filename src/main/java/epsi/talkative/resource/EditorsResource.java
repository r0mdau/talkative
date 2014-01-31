package epsi.talkative.resource;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import epsi.talkative.bean.Editor;
import epsi.talkative.repository.EditorRepository;

@Path("editors")
public class EditorsResource {

	@EJB
	private EditorRepository editorRepository;

	@Path("{editor}")
	public EditorResource getEditor(@PathParam("editor") String editorId) {
		if (!editorRepository.contains(editorId)) {
			throw new WebApplicationException(Status.FORBIDDEN);
		}
		return new EditorResource();
	}

	@POST
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public Response post(Editor editor) {
		editor.setTimestamp(System.currentTimeMillis());
		if (editor.getLogin().isEmpty() || editor.getMail().isEmpty()
				|| editor.getPassword().isEmpty())
			return Response.status(400).entity(editor).build();
		else
			return Response
					.status(200)
					.entity(editor)
					.header("Link",
							"http://localhost:8080/talkative/api/editors/"
									+ editor.getLogin()).build();
	}
}