package feng.todoList.dao;

import feng.todoList.model.TodoItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 10503313 on 2017/7/10.
 */
@Repository
public class TodoDAOImpl implements TodoDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TodoItem> getAllTodos(){
        return sessionFactory.getCurrentSession().createQuery("from TodoItem")
                .list();
    }

    @Override
    public void addTodoItem(TodoItem todoItem) {
        sessionFactory.getCurrentSession().saveOrUpdate(todoItem);
    }

    @Override
    public TodoItem updateTodoItem(TodoItem todoItem) {
        sessionFactory.getCurrentSession().update(todoItem);
        return todoItem;
    }

    @Override
    public void deleteTodoItem(Integer todoItemId) {
        TodoItem todoItem = (TodoItem) sessionFactory.getCurrentSession().load(
                TodoItem.class, todoItemId);
        if (null != todoItem) {
            this.sessionFactory.getCurrentSession().delete(todoItem);
        }
    }
}
