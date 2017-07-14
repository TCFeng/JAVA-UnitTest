package feng.todoList.dao;

import feng.todoList.model.TodoItem;

import java.util.List;

/**
 * Created by 10503313 on 2017/7/9.
 */
public interface TodoDAO {

    public List<TodoItem> getAllTodos();
}
