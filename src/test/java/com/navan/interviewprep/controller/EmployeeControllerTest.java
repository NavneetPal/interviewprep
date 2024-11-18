package com.navan.interviewprep.controller;

import com.navan.interviewprep.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @WebMvcTest(EmployeeController.class)
 * This annotation tells Spring to only load the web layer for the specified controller, which helps in isolating tests.
 * Spring Boot provides the @WebMvcTest annotation to fire up an application context that contains only the beans needed for testing a web controller:
 */
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    /**
     *This is used to perform HTTP requests and assert responses without starting a server.
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * This is used to create a mock instance of EmployeeService so that we can define its behavior without needing an actual implementation.
     */
    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testGreetWithDefaultName() throws Exception {
        when(employeeService.greet(anyString())).thenReturn("Hello, World!");

        mockMvc.perform(get("/employee/greet").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testGreetWithCustomName() throws Exception {
        when(employeeService.greet("Alice")).thenReturn("Hello, Alice!");

        mockMvc.perform(get("/greet?name=Alice").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Alice!"));
    }

}