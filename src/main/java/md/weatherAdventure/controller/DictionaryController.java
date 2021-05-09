package md.weatherAdventure.controller;

import md.weatherAdventure.dto.MenuDto;
import md.weatherAdventure.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(DictionaryController.URL_PREFIX)
public class DictionaryController {

    public static final String URL_PREFIX = "/dictionary";
    public static final String GET_MENU = "/get_menu";

    MenuServiceImpl menuService;

    @Autowired
    public void setMenuService(MenuServiceImpl menuService) {
        this.menuService = menuService;
    }

    @RequestMapping(method = RequestMethod.GET, value = GET_MENU)
    public List<MenuDto> getMenuList()
    {
        return menuService.getMenuList();
    }
}
