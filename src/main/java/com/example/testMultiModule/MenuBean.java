package com.example.testMultiModule;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named(value = "confBean")
@Component
@Scope("view")
@Getter
@Setter
@Log4j2
public class MenuBean {
    private MenuModel modelMenu;

    @PostConstruct
    public void init() {
        modelMenu = generationMenu();
    }

    private MenuModel generationMenu() {
        MenuModel model = new DefaultMenuModel();
        String url = "https://www.primefaces.org/";
        DefaultSubMenu firstSubmenu = DefaultSubMenu.builder()
                .label("FirstSubMenu")
                .expanded(true)
                .build();
        DefaultSubMenu secondSubmenu = DefaultSubMenu.builder()
                .label("SecondSubMenu")
                .expanded(false)
                .build();

        int i = 0;
        for (int j = 0; j < 5; j++) {
            DefaultMenuItem item = DefaultMenuItem.builder()
                    .value("menu" + i)
                    .url(url)
                    .build();

            if (j == 3) {
                item.setStyle("background-color: #b0defc;");
            }
            firstSubmenu.getElements().add(item);
            i++;
        }
        model.getElements().add(firstSubmenu);


        for (int j = 0; j < 5; j++) {
            DefaultMenuItem item = DefaultMenuItem.builder()
                    .value("menu" + i++)
                    .url(url)
                    .build();

            secondSubmenu.getElements().add(item);
        }
        model.getElements().add(secondSubmenu);


        return model;
    }
}
