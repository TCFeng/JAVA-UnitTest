package feng.todoList.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import feng.todoList.AbstractIntegrationTest;
import feng.todoList.model.TodoItem;
import feng.todoList.service.TodoService;
import feng.todoList.util.RandomUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 10503313 on 2017/7/15.
 */
public class TodoControllerTest extends AbstractIntegrationTest {

    @Autowired
    private MappingJackson2HttpMessageConverter jsonMessageConvert;

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
    public void getListTest() throws Exception {

        ObjectMapper objectMapper = jsonMessageConvert.getObjectMapper();
        List<TodoItem> todoItems = this.createTodoItems();
        Mockito.when(todoService.getTodosList()).thenReturn(todoItems);

        ResultActions result = this.mockMvc.perform(post("/todoList/getList"))
                .andExpect(status().isOk());

        String content = result.andReturn().getResponse().getContentAsString();
        assertEquals(objectMapper.writeValueAsString(this.createListReturnMap(todoItems)), content);
    }

    @Test
    public void addItemEmptyTest() throws Exception {

        // Mockito.when(todoService.addTodoItem(this.createEmptyTodoItem()));

        ObjectMapper objectMapper = jsonMessageConvert.getObjectMapper();
        ResultActions result = this.mockMvc.perform(post("/todoList/addItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(this.createEmptyTodoItem())))
                .andExpect(status().isOk());

        String content = result.andReturn().getResponse().getContentAsString();
        assertEquals("{\"AddItem\":\"Data Empty\"}", content);
    }

    @Test
    public void addItemTest() throws Exception {

        ObjectMapper objectMapper = jsonMessageConvert.getObjectMapper();
        ResultActions result = this.mockMvc.perform(post("/todoList/addItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(this.createTodoItem())))
                .andExpect(status().isOk());

        String content = result.andReturn().getResponse().getContentAsString();
        assertEquals("{\"AddItem\":\"OK!!\"}", content);
    }

    @Test
    public void updateItemTest() throws Exception {
    }

    @Test
    public void deleteItemTest() throws Exception {
    }

    private List<TodoItem> createTodoItems(){

        List<TodoItem> resultList = new ArrayList<TodoItem>();
        TodoItem todoItem = new TodoItem();
        todoItem.setId(RandomUtil.randomPositiveInt(5));
        todoItem.setItem(RandomUtil.randomString());
        todoItem.setOwner(RandomUtil.randomString());
        todoItem.setDueDate(RandomUtil.randDateTime());
        todoItem.setDone(RandomUtil.randomBoolean());

        resultList.add(todoItem);
        return resultList;

    }

    private Map<String, List<TodoItem>> createListReturnMap(List<TodoItem> resultList){
        Map<String, List<TodoItem>> resultMap = new HashMap<String, List<TodoItem>>();
        resultMap.put("QueryData", resultList);
        return resultMap;
    }

    private TodoItem createTodoItem() {

        TodoItem todoItem = new TodoItem();
        todoItem.setItem(RandomUtil.randomString());
        todoItem.setOwner(RandomUtil.randomString());
        todoItem.setDueDate(RandomUtil.randDateTime());
        todoItem.setDone(RandomUtil.randomBoolean());

        return todoItem;
    }

    private TodoItem createEmptyTodoItem() {

        TodoItem todoItem = new TodoItem();
        todoItem.setOwner(RandomUtil.randomString());
        todoItem.setDueDate(RandomUtil.randDateTime());
        todoItem.setDone(RandomUtil.randomBoolean());

        return todoItem;
    }
}