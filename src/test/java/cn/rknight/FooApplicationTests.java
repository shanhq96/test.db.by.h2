package cn.rknight;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FooApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testStartFooApplication() throws Exception {
        FooApplication.main(new String[0]);
        this.mvc.perform(get("/student/helloWorld")).andExpect(status().isOk()).andExpect(content().json("{\"errorMsg\":\"helloWorld\"}"));
        MvcResult mvcResult = this.mvc.perform(get("/student/")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        this.mvc.perform(get("/student/")).andExpect(status().isOk()).andExpect(content().json("[{}]"));
    }
}
