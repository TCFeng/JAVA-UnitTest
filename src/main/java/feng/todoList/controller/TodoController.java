package feng.todoList.controller;

import feng.todoList.model.TodoItem;
import feng.todoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 10503313 on 2017/7/3.
 */
@Controller
@RequestMapping(value = "/todoList")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(path = "/getList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getList(){

        Map testMap = new HashMap();
        List<TodoItem> listTodo = todoService.getTodosList();
        testMap.put("QueryData", listTodo);

        return testMap;
    }

    @RequestMapping(path = "/addItem", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addItem() {

        Map testMap = new HashMap();
        testMap.put("AddItem", "OK!!");

        return testMap;
    }

    @RequestMapping(path = "/updateItem", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateItem() {

        Map testMap = new HashMap();
        testMap.put("UpdateItem", "OK!!");

        return testMap;
    }

    @RequestMapping(path = "/deleteItem", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteItem() {

        Map testMap = new HashMap();
        testMap.put("DeleteItem", "OK!!");

        return testMap;
    }
}
