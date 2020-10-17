package app.controller;

import app.entity.BusinessServiceJob;
import app.security.JwtAuthenticationEntryPoint;
import app.security.JwtTokenProvider;
import app.service.BusinessServiceService;
import app.service.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BusinessServiceController.class)
public class BusinessServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @MockBean
    private CustomUserDetailsService customUserDetailsService;
    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private BusinessServiceService businessServiceService;

    @Test
    void createService_OkAndBusinessService_IfValidRequest() throws Exception{
        BusinessServiceJob businessServiceJob = new BusinessServiceJob(10, "Computer Repair");
        when(businessServiceService.createService(any(BusinessServiceJob.class)))
                .thenReturn(businessServiceJob);

        mvc.perform(post("/services/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"serviceLength\":10,\"serviceDescription\":\"Computer Repair\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.serviceLength").value(10))
                .andExpect(jsonPath("$.serviceDescription").value("Computer Repair"));
    }

    @Test
    void createService_BadRequestAndMessage_IfServiceLengthIs0() throws Exception{
        mvc.perform(post("/services/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"serviceLength\":0,\"serviceDescription\":\"Computer Repair\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value("Error: Invalid Business Service object."));
    }

    @Test
    void createService_BadRequestAndMessage_IfServiceDescriptionIsBlank() throws Exception{
        mvc.perform(post("/services/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"serviceLength\":10,\"serviceDescription\":\"\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value("Error: Invalid Business Service object."));
    }

    @Test
    void removeService_OkAndMessage_IfValidRequest() throws Exception{
        Integer serviceID = 1;
        when(businessServiceService.removeService(serviceID)).thenReturn(true);

        mvc.perform(delete("/services/remove")
                .param("serviceID", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$")
                        .value("Service #" + serviceID.toString() + " successfully removed."));
    }

    @Test
    void removeService_BadRequestAndMessage_IfServiceIdIsNull() throws Exception{
        mvc.perform(delete("/services/remove")
                .param("serviceID", "")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$")
                        .value("Error: Failed to remove service. Enter a service ID."));
    }

    @Test
    void removeService_BadRequestAndMessage_IfServiceIdDoesNotExist() throws Exception{
        Integer serviceID = 2;
        when(businessServiceService.removeService(serviceID)).thenReturn(false);

        mvc.perform(delete("/services/remove")
                .param("serviceID", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$")
                        .value("Error: Failed to remove service #" + serviceID.toString() + "\n"
                                + "Service not found."));
    }
}
