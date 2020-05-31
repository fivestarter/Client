package ru.fivestarter.client.main;

import ru.fivestarter.client.user.UserService;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class SecondPage extends WebPage {

    @SpringBean
    private UserService userService;

    public SecondPage() {
        add(new Label("firstName", userService.getUser().getFirstName()));
        add(new Label("lastName", userService.getUser().getLastName()));
    }
}
