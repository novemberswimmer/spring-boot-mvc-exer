package org.november.swimmer;

import org.november.swimmer.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @RequestMapping(value = "/helloEdit", method = RequestMethod.GET)
    public String getHelloEdit(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "helloEdit";
    }

    @RequestMapping(value="/helloEdit", method=RequestMethod.POST)
    public String postHelloEdit(@ModelAttribute("person") Person person) {
        return "hello";
    }
}
