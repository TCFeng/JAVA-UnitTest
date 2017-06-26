package feng.todoList.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/test")
public class testController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String showHelloWorld(){

        return "OK";
    }
}