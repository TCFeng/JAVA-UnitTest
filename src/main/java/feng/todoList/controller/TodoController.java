package feng.todoList.controller;

import feng.todoList.model.TodoItem;
import feng.todoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    // , produces="application/json"
    @RequestMapping(path = "/addItem", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addItem(@RequestBody TodoItem todoItem) {

        Map testMap = new HashMap();
        if(todoItem.getItem() == null || todoItem.getItem().equals("")){
            testMap.put("AddItem", "Data Empty");
        }else{
            todoService.addTodoItem(todoItem);
            testMap.put("AddItem", "OK!!");
        }

        return testMap;
    }

    @RequestMapping(path = "/updateItem", method = RequestMethod.POST)
    @ResponseBody
    public TodoItem updateItem(@RequestBody TodoItem todoItem) {

        TodoItem result = todoService.updateTodoItem(todoItem);
        return result;
    }

    @RequestMapping(path = "/deleteItem", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteItem(@RequestBody TodoItem todoItem) {

        todoService.deleteTodoItem(todoItem.getId());
        Map testMap = new HashMap();
        testMap.put("DeleteItem", "OK!!");

        return testMap;
    }
}
