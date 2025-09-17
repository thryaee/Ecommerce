package com.nie.csd.controllersTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;

import com.nie.csd.controller.ProductController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

// @SpringBootTest
// public class ProductControllerTestClass {
    
// @Autowired
// ProductController controller;
// @Test
// public void testSayHello() {
//     String result = controller.sayhello();
//     String expected = "HELLO";
//     assert(result.equals(expected));
// }
// }
@WebMvcTest(ProductController.class)
public class ProductControllerTestClass {
    
@Autowired
MockMvc mockMvc;

@Test
public void testSayHello() throws Exception {
    mockMvc.perform(get("/hello"))
    .andExpect(status().isOk())
    .andExpect(content().string("hello"));
}
}
