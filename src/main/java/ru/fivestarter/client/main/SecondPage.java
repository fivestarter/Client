package ru.fivestarter.client.main;

import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.lambda.components.ComponentFactory;

import ru.fivestarter.client.user.UserService;

public class SecondPage extends WebPage {

    private final IModel<String> labelModel = Model.of("Hello WicketWorld!");
    private final Label label = new Label("luna", labelModel);
    @SpringBean
    private UserService userService;

    public SecondPage() {
        setDefaultModel(new CompoundPropertyModel<>(userService.getUser()));
        add(new Label("firstName"));
        add(new Label("lastName"));
        add(ComponentFactory.ajaxLink("button", (ajaxLink, ajaxTarget) -> {
            labelModel.setObject("Ku-ku");
            ajaxTarget.add(label);
        }));
        add(label.setOutputMarkupId(true));
    }
}
