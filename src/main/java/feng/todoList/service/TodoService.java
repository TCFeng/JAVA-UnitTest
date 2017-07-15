package feng.todoList.service;

import feng.todoList.model.TodoItem;

import java.util.List;

/**
 * Created by 10503313 on 2017/7/3.
 */
public interface TodoService {

    List<TodoItem> getTodosList();

    public void addTodoItem(TodoItem todoItem);

    public TodoItem updateTodoItem(TodoItem todoItem);

    public void deleteTodoItem(int todoItemId);
}
