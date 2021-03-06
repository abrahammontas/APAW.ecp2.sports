package es.upm.miw.apiArchitectureTheme;

import es.upm.miw.apiArchitectureTheme.api.UserResource;
import es.upm.miw.apiArchitectureTheme.api.SportResource;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidNameException;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidRequestException;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidUserFieldException;
import es.upm.miw.apiArchitectureTheme.exceptions.SportNameNotDefined;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {

	private UserResource userResource = new UserResource();
	private SportResource sportResource = new SportResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		// **/users
		if ("users".equals(request.getPath())) {
			response.setBody(userResource.userList().toString());
			// **/users/search
		} else if ("users".equals(request.paths()[0]) && "search".equals(request.paths()[1])
				&& (request.getParams().size() == 1 && request.getParams().containsKey("sport"))) {
			try {
				response.setBody(userResource.searchBySport(request.getParams().get("sport")).toString());
			} catch (Exception e) {
				responseError(response, e);
			}
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) throws InvalidNameException, SportNameNotDefined {
		 switch (request.getPath()) {
		 // POST **/users body="nick:email"
		 case "users":
	          String nick = request.getBody().split(":")[0];
	          String email = request.getBody().split(":")[1];
	             
    		 try {
        		 userResource.createUser(nick, email);
        		 response.setStatus(HttpStatus.CREATED);
    		 } catch (InvalidUserFieldException e) {
    		     this.responseError(response, e);
    		 }
		 break;
		 
		 // POST sports body="name"
		 case "sports":
    		 try {
        		 sportResource.createSport(request.getBody());
        		 response.setStatus(HttpStatus.CREATED);
    		 } catch (Exception e) {
    		     responseError(response, e);
    		 }
		 break;
		 default:
    		 responseError(response, new
    		 InvalidRequestException(request.getPath()));
		 break;
		 }
	}

	public void doPut(HttpRequest request, HttpResponse response) {

	}

	public void doDelete(HttpRequest request, HttpResponse response) {

	}

}