package feng.todoList.service;

import feng.todoList.dao.TodoDAO;
import feng.todoList.model.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 10503313 on 2017/7/3.
 */
@Service("todoService")
@Transactional
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoDAO todoDAO;

    @Override
    @Transactional
    public List<TodoItem> getTodosList() {
        return todoDAO.getAllTodos();
    }
}
