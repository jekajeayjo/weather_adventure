package md.weatherAdventure.controller;

import md.weatherAdventure.dto.AuthenticationRequestDto;
import md.weatherAdventure.service.impl.AuthorizationServicempl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController {
    private static final String LOGIN_ENDPOINT = "/autorization";
    AuthorizationServicempl authorizationService;
@Autowired
    public void setAuthorizationService(AuthorizationServicempl authorizationService) {
        this.authorizationService = authorizationService;
    }

    @RequestMapping(value = LOGIN_ENDPOINT, method = RequestMethod.POST)
    public ResponseEntity auth(@RequestBody AuthenticationRequestDto requestDto) {
        return ResponseEntity.ok(authorizationService.authorization(requestDto));

    }
}
