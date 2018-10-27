package ru.bmstu.templebase.controller;


import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.bmstu.templebase.manager.BaseManager;
import ru.bmstu.templebase.model.Temple;
import ru.bmstu.templebase.model.TempleFields;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(TempleController.class)
public class TempleControllerTest {

    private static  List<Temple> TEMPLES;

    static {
        TEMPLES = new ArrayList<>();
        Temple t = new Temple();
        t.setId(1);
        t.setName("Test1");
        TEMPLES.add(t);
        t = new Temple();
        t.setId(2);
        t.setName("Test2");
        TEMPLES.add(t);
    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BaseManager<Temple, TempleFields> service;

    @Test
    public void testAll() throws Exception {


        when(service.getAll()).thenReturn(TEMPLES);
        when(service.get(1)).thenReturn(findById(1));

        this.mockMvc.perform(get("/temples/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Test1\"}"));
        this.mockMvc.perform(get("/temples")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Test1\"},{\"id\":2,\"name\":\"Test2\"}]"));
    }

    static Temple findById(int id) {
        for(Temple t: TEMPLES) {
            if(id==t.getId()) {
                return t;
            }
        }
        return null;
    }
}
