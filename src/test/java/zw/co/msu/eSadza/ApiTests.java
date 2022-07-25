package zw.co.msu.eSadza;

import com.fasterxml.jackson.databind.ObjectMapper;
import zw.co.msu.eSadza.controller.CartController;
import zw.co.msu.eSadza.controller.FoodController;
import zw.co.msu.eSadza.controller.LoginController;
import zw.co.msu.eSadza.controller.RegistrationController;
import zw.co.msu.eSadza.service.CartServiceImpl;
import zw.co.msu.eSadza.service.FoodServiceImpl;
import zw.co.msu.eSadza.repository.UserRepository;
import zw.co.msu.eSadza.service.UserServiceImpl;
import zw.co.msu.eSadza.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({LoginController.class, RegistrationController.class, FoodController.class, CartController.class})
public class ApiTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    UserRepository userRepository;

    @MockBean
    UserServiceImpl userServiceImpl;

    @MockBean
    FoodServiceImpl foodDao;

    @MockBean
    CartServiceImpl cartDao;

    @Test
    public void getLoginApi() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                    .get("/login")
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk());
    }

    @Test
    public void getRegisterApi() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .get("/api/register")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postRegisterAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/register")
                .content(asJsonString(new User("aman","abcd1234","bbbb","bbbb","b@gmail.com","bbbb",1234,true)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void postCheckUsernameApi() throws Exception{
        mvc.perform( MockMvcRequestBuilders
                .post("/checkUserName")
                .content("amank").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getMenuApi() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .get("/menu")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void getChangeDBCartApi() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .get("/changeDB")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
