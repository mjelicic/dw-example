package miro.api;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {

  private Provider<HttpServletRequest> request;
  private UserService userService;
  @Inject
  public HelloResource(Provider<HttpServletRequest> request, UserService userService) {
    this.request = request;
    this.userService = userService;
  }

  @GET
  public Response hello(@QueryParam("id") @DefaultValue("1") Long id) {
    return Response.ok(
            String.format("Hello %s from %s", userService.getById(id).getName(), request.get().getRemoteAddr()))
        .build();
  }

}
