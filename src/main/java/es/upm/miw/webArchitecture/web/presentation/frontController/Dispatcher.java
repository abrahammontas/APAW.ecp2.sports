package es.upm.miw.webArchitecture.web.presentation.frontController;

import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.webArchitecture.web.presentation.models.Model;
import es.upm.miw.webArchitecture.web.presentation.presenters.UI1Presenter;
import es.upm.miw.webArchitecture.web.presentation.presenters.UI2Presenter;
import es.upm.miw.webArchitecture.web.presentation.presenters.UI3Presenter;
import es.upm.miw.webArchitecture.web.presentation.views.ErrorView;
import es.upm.miw.webArchitecture.web.presentation.views.UI1View;
import es.upm.miw.webArchitecture.web.presentation.views.UI2View;
import es.upm.miw.webArchitecture.web.presentation.views.UI3View;
import es.upm.miw.webArchitecture.web.presentation.views.View;

public class Dispatcher {

    public void doGet(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String nextView = request.getPath() + "View";

        switch (presenter) {
        case "UI1Presenter":
            UI1Presenter uI1Presenter = new UI1Presenter();
            nextView = uI1Presenter.process(model);
            break;
        case "UI2Presenter":
            UI2Presenter uI2Presenter = new UI2Presenter();
            nextView = uI2Presenter.process(model);
            break;
        case "UI3Presenter":
            UI3Presenter uI3Presenter = new UI3Presenter();
            nextView = uI3Presenter.process(model);
            break;
        }
        this.show(nextView, model);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String controller = request.getPath() + "Presenter";
        String action = request.getParams().get("action");
        String nextView = request.getPath() + "View";

        switch (controller) {
        case "UI1Presenter":
            UI1Presenter uI1Presenter = new UI1Presenter();
            if ("login".equals(action)) {
                // TODO uI1Presenter.setters((request.getParams().get("param")));
                nextView = uI1Presenter.login(model);
            } else if ("logout".equals(action)) {
                // TODO uI1Presenter.setters((request.getParams().get("param")));
                nextView = uI1Presenter.logout(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case "UI2Presenter":
            UI2Presenter uI2Presenter = new UI2Presenter();
            if ("action1".equals(action)) {
                // TODO uI2Presenter.setters((request.getParams().get("param")));
                nextView = uI2Presenter.action1(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case "UI3Presenter":
            UI3Presenter uI3Presenter = new UI3Presenter();
            if ("action2".equals(action)) {
                // TODO uI3Presenter.setters((request.getParams().get("param")));
                nextView = uI3Presenter.action2(model);
            } else if ("action3".equals(action)) {
                // TODO uI3Presenter.setters((request.getParams().get("param")));
                nextView = uI3Presenter.action3(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        }
        this.show(nextView, model);
    }

    private void show(String nextView, Model model) {
        View view;
        switch (nextView) {
        case "UI1View":
            view = new UI1View();
            break;
        case "UI2View":
            view = new UI2View();
            break;
        case "UI3View":
            view = new UI3View();
            break;
        default:
            view = new ErrorView();
            model.put("error", "Vista no encontrada: " + nextView);
        }
        view.show(model);
    }

}
