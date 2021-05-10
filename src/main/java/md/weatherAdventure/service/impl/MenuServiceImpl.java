package md.weatherAdventure.service.impl;

import md.weatherAdventure.dto.MenuDto;
import md.weatherAdventure.entity.MenuEntity;
import md.weatherAdventure.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl {
    List<MenuDto> menu = new ArrayList<>();
    List<MenuDto> group = new ArrayList<>();

    MenuRepository menuRepository;

    @Autowired
    @Cacheable( "menu")
    public void setMenuRepository(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    public List<MenuDto> getMenuList() {
        menu.clear();
            reformatJson(menuRepository.findAll(), null);
            return menu;


    }
    private void reformatJson(List<MenuEntity> menuEntities, Long parentId) {
        Long id = null;

        for (MenuEntity item : menuEntities) {
            id = item.getParentId() == null ? null : item.getParentId().getId();

            if (id == parentId) {
                if (item.getUrl()== null||item.getUrl().equals("")) {
                    reformatJson(menuEntities, item.getId());
                    MenuDto menuDto = new MenuDto(item);
                    List<MenuDto> subMenu = new ArrayList<>();
                    subMenu.addAll(group);
                    menuDto.setChildren(subMenu);
                    menu.add(menuDto);
                    group.clear();
                } else if (!item.getUrl().equals("") && parentId == null) {
                    menu.add(new MenuDto(item));
                } else {
                    group.add(new MenuDto(item));
                }
            }
        }
    }
}
