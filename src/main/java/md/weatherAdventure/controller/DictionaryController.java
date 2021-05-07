package md.weatherAdventure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DictionaryController.URL_PREFIX)
public class DictionaryController {

public static final String URL_PREFIX="/dictionary";
}
