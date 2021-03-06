package es.upm.miw.apiArchitectureTheme;

import es.upm.miw.apiArchitectureTheme.exceptions.InvalidNameException;
import es.upm.miw.apiArchitectureTheme.exceptions.SportNameNotDefined;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;

public class Server {
	private Dispatcher dispatcher = new Dispatcher();

	public HttpResponse request(HttpRequest request) throws InvalidNameException, SportNameNotDefined {
		HttpResponse response = new HttpResponse();
		switch (request.getMethod()) {
		case POST:
			dispatcher.doPost(request, response);
			break;
		case GET:
			dispatcher.doGet(request, response);
			break;
		case PUT:
			dispatcher.doPut(request, response);
			break;
		case DELETE:
			dispatcher.doDelete(request, response);
			break;
		default:
		}
		return response;
	}

}