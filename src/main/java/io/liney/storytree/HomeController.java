package io.liney.storytree;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/pos", method = RequestMethod.GET)
public class HomeController {

    @RequestMapping(value = "/{position}", method = RequestMethod.GET)
    public String index2(@PathVariable("position") String position) {
        return returnIndex();
    }

    private String returnIndex() {
        return "index";
    }
}