package org.november.swimmer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getHelloTest() throws Exception {
        MvcResult result = mockMvc.perform(get("/hello")).andExpect(status().isOk()).andReturn();

        Assert.assertNotNull("result return is null",result);
    }

    @Test
    public void testGetHelloEditPage() throws Exception {
        MvcResult result = mockMvc.perform(get("/helloEdit")).andExpect(status().isOk()).andReturn();

        Assert.assertNotNull("result return is null", result);
    }

    @Test
    public void testPostHelloEditPage() throws Exception {
        MvcResult result = mockMvc.perform(post("/helloEdit")).andExpect(status().isOk()).andReturn();
        Assert.assertNotNull("result return is null", result);
    }
}
