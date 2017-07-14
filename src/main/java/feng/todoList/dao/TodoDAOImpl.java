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

    public List<TodoItem> getAllTodos(){
        return sessionFactory.getCurrentSession().createQuery("from TodoItem")
                .list();
    }
}
