package md.weatherAdventure.controller;

import md.weatherAdventure.dto.UserDto;
import md.weatherAdventure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserController.URL_PREFIX)
public class UserController {
    public static final String URL_PREFIX = "/user";
    public static final String GET = "/get/{id}";
    public static final String SAVE = "/save";

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, value = GET)
    public Object getUser() {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = SAVE)
    public UserDto save(@RequestBody UserDto dto) {
        return userService.save(dto);
    }

}
