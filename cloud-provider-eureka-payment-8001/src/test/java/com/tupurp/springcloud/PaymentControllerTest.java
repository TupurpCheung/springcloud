package com.tupurp.springcloud;

import com.tupurp.springcloud.controller.PaymentController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @description: 支付web测试
 * @author: tupurp
 * @create: 2020-05-31 16:46
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PaymentControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private  PaymentController paymentController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void postCreatePayment()throws Exception {


        mockMvc.perform(post("/payment/create")
                .param("serial","1156bvda")
                .accept(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk()).andDo(print());

    }
}