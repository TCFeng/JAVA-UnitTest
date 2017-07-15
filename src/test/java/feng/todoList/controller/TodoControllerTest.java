package feng.todoList.controller;

import feng.todoList.AbstractIntegrationTest;
import feng.todoList.model.TodoItem;
import feng.todoList.service.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 10503313 on 2017/7/15.
 */
public class TodoControllerTest extends AbstractIntegrationTest {

    @InjectMocks
    private TodoController todoController;

    @Mock
    TodoService todoService;

    @Before
    @Override
    public void setup() {
        MockitoAnnotations.initMocks(this);
        // this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(todoController).build();
    }


    @Test
    public void getList() throws Exception {
        // MvcResult result = this.mockMvc.perform(post("/todoList/getList")).andExpect(status().isOk()).andReturn();

        Mockito.when(todoService.getTodosList()).thenReturn(this.createTodoItems());

        ResultActions result = this.mockMvc.perform(post("/todoList/getList")).andExpect(status().isOk());
        String content = result.andReturn().getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void addItem() throws Exception {
    }

    @Test
    public void updateItem() throws Exception {
    }

    @Test
    public void deleteItem() throws Exception {
    }

    private List<TodoItem> createTodoItems(){

        List<TodoItem> resultList = new ArrayList<TodoItem>();
        TodoItem todoItem = new TodoItem();
        todoItem.setId(100);
        todoItem.setItem("Show me the money");
        todoItem.setDueDate("19870601000000");
        todoItem.setDone(true);

        resultList.add(todoItem);
        return resultList;

    }
}