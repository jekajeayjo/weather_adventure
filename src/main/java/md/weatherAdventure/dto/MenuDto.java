package md.weatherAdventure.dto;

import md.weatherAdventure.entity.MenuEntity;

import java.util.ArrayList;
import java.util.List;

public class MenuDto {
    private  String icon;
    private String name;
    private String route;
    private List<MenuDto> children=new ArrayList<>();
    public MenuDto(MenuEntity entity) {
        setIcon(entity.getIcon());
        setName(entity.getText());
        setRoute(entity.getUrl());
    }
    public MenuDto(String icon, String name, String route) {
        this.icon = icon;
        this.name = name;
        this.route = route;
    }
    public MenuDto() {
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public List<MenuDto> getChildren() {
        return children;
    }

    public void setChildren(List<MenuDto> children) {
        this.children = children;
    }
}
