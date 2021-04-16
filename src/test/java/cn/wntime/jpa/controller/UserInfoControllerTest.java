package cn.wntime.jpa.controller;

import cn.wntime.jpa.RbacJpaApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

class UserInfoControllerTest extends RbacJpaApplicationTests {

    @Test
    void userInfoList() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/user/list")
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void add() throws Exception {
        MvcResult mvcResult = this.mockMvc
                .perform(get("/user/add").contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void exception() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/user/exception").contentType(MediaType.APPLICATION_JSON)).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}