package es.upm.miw.webArchitecture.web.presentation.presenters;

import es.upm.miw.webArchitecture.rest.business.controllers.BusinessController1;
import es.upm.miw.webArchitecture.rest.business.views.TransferObject2;
import es.upm.miw.webArchitecture.web.presentation.models.Model;

public class UI1Presenter {

    public String process(Model model) {
        model.put("log", "UI1Presenter:process");
        return "UI1View";
    }

    public String login(Model model) {
        model.put("log", "UI1Presenter:login");
        new BusinessController1().m2(new TransferObject2());
        return "UI1View";
    }

    public String logout(Model model) {
        model.put("log", "UI1Presenter:logout");
        new BusinessController1().m2(new TransferObject2());
        return "UI1View";
    }

}
