package org.november.swimmer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGreeting_NoRequestParam() throws Exception {
      MvcResult result =  callControllerHandlerMethod("/greeting");
      String content = result.getResponse().getContentAsString();
      Assert.assertTrue("Error HTML Body does not contain expected content",content.contains("Hello, World!"));
    }

    @Test
    public void testGreeting_RequestParamGiven() throws Exception {
        MvcResult result = callControllerHandlerMethod("/greeting?name=Joe");
        String content = result.getResponse().getContentAsString();
        Assert.assertTrue("Error HTML Body does not contain expected content", content.contains("Hello, Joe!"));
    }

    @Test
    public void testGreeting_SessionValue() throws Exception {
        MvcResult result = callControllerHandlerMethod("/greetingSession?name=Joe");
        String sessionName = result.getRequest().getSession().getAttribute("name").toString();
        Assert.assertTrue("Error expected session value not found", sessionName.equals("Joe"));
    }

    private MvcResult callControllerHandlerMethod(String url) throws Exception {
        return mockMvc.perform(get(url).accept(MediaType.TEXT_PLAIN)).andExpect(status().isOk()).andReturn();
    }
}
