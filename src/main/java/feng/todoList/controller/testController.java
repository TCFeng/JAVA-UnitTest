package feng.todoList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/todoList")
public class testController {

    @RequestMapping(path = "/getList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> showHelloWorld(){

        Map testMap = new HashMap();
        testMap.put("dataA", "OK");

        return testMap;
    }
}