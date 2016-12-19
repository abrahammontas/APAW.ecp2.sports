package es.upm.miw.webArchitecture.web.presentation.presenters;

import es.upm.miw.webArchitecture.rest.business.controllers.BusinessController2;
import es.upm.miw.webArchitecture.rest.business.views.TransferObject2;
import es.upm.miw.webArchitecture.web.presentation.models.Model;

public class UI2Presenter {

    public String process(Model model) {
        model.put("log", "UI2Presenter:process");
        return "UI2View";
    }

    public String action1(Model model) {
        model.put("log", "UI2Presenter:action1");
        TransferObject2 transferObject2 = new BusinessController2().m1();
        model.put("transferObject2", transferObject2);
        return "UI2View";
    }

}
