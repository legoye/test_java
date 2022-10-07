package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.test.model.Entity.Phone;
import com.test.model.Entity.User;
import com.test.model.UserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class SpringBootJwtApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnUnauthorizedAuInsertedUser() throws Exception {

        String url = "/users";
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("test@test.com");
        userRequest.setName("Test");
        userRequest.setPassword("passwordcorrect");
        List<Phone> phoneList = new ArrayList<>();
        Phone phone = new Phone();
        phone.setNumber("23456732");
        phone.setCityCode("52");
        phone.setCityCode("94300");
        phoneList.add(phone);
        userRequest.setPhones(phoneList);


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(userRequest);

        this.mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(requestJson)).andDo(print()).andExpect(status().is4xxClientError());;
    }

}
