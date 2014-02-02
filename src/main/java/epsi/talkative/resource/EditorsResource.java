package epsi.talkative.resource;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import epsi.talkative.bean.Editor;
import epsi.talkative.bean.StringValidator;
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

	@PUT
	@Path("{editor}")
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public Response put(Editor editor) {
		editor.setTimestamp(System.currentTimeMillis());
		if (!editor.getLogin().isEmpty() && !editor.getMail().isEmpty()
				&& !editor.getPassword().isEmpty()
				&& StringValidator.validateMail(editor.getMail()))
			return Response
					.status(Status.CREATED)
					.entity(editor)
					.build();
		else
			return Response.status(400).entity(editor).build();
	}
}