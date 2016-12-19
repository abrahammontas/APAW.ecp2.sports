package es.upm.miw.webArchitecture.web.presentation.views;

import es.upm.miw.webArchitecture.web.presentation.models.Model;

public class UI3View implements View{

    @Override
    public void show(Model model) {
        System.out.println("UI3View");
        System.out.println("   " + model.get("log"));
    }

}
