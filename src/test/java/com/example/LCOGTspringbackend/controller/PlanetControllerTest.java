package com.example.LCOGTspringbackend.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import com.example.LCOGTspringbackend.service.PlanetService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PlanetControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private PlanetService planetService;

        @Test
        void testSavePlanet() throws Exception {

                mockMvc.perform(
                                post("/planets")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content("{\r\n"
                                                                + "\"name\": \"Saturn\",\r\n  \"size\": 95.2,\r\n  \"distance\": 9.6,\r\n  \"ordinality\": 6,\r\n  \"description\": \"It has rings.\""
                                                                + "\r\n}"))
                                .andExpect(status().isOk());

        }

        @Test
        void testSavePlanetFailsSizeError() throws Exception {

                mockMvc.perform(
                                post("/planets")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content("{\r\n"
                                                                + "\"name\": \"Saturn\",\r\n  \"size\": 950000.2,\r\n  \"distance\": 9.6,\r\n  \"ordinality\": 6,\r\n  \"description\": \"It has rings.\""
                                                                + "\r\n}"))
                                .andExpect(status().isBadRequest());

        }

        @Test
        void testSavePlanetFailsDistanceError() throws Exception {

                mockMvc.perform(
                                post("/planets")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content("{\r\n"
                                                                + "\"name\": \"Saturn\",\r\n  \"size\": 95.2,\r\n  \"distance\": 1009.6,\r\n  \"ordinality\": 6,\r\n  \"description\": \"It has rings.\""
                                                                + "\r\n}"))
                                .andExpect(status().isBadRequest());

        }

        @Test
        void testSavePlanetFailsOrdinalityError() throws Exception {

                mockMvc.perform(
                                post("/planets")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content("{\r\n"
                                                                + "\"name\": \"Saturn\",\r\n  \"size\": 95.2,\r\n  \"distance\": 9.6,\r\n  \"ordinality\": 9,\r\n  \"description\": \"It has rings.\""
                                                                + "\r\n}"))
                                .andExpect(status().isBadRequest());

        }

        @Test
        void testSavePlanetFailsDescriptionError() throws Exception {

                mockMvc.perform(
                                post("/planets")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content("{\r\n"
                                                                + "\"name\": \"Saturn\",\r\n  \"size\": 95.2,\r\n  \"distance\": 9.6,\r\n  \"ordinality\": 9,\r\n  \"description\": Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut rhoncus odio quis nunc ornare vestibulum. Curabitur sit amet consequat ligula. Duis tempus eget eros sed vulputate. Aliquam nisi est, mattis at malesuada quis, auctor vitae nunc. Duis tincidunt, quam ac laoreet luctus, massa arcu condimentum tortor, quis aliquet tortor lorem nec purus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam pulvinar condimentum libero. In eget hendrerit odio, sit amet ultricies dui. Praesent convallis orci quis dui imperdiet, eget dignissim nisl placerat. Mauris facilisis libero ex, eu mattis dolor vestibulum eget. Nunc porta non diam et mollis. Vivamus bibendum malesuada urna ut hendrerit. Praesent accumsan, risus id pellentesque iaculis, leo nisi malesuada nunc, at eleifend diam metus ac orci. Cras ac mauris rutrum, consequat mi eget, pretium massa. Duis dapibus euismod risus, quis gravida nibh fermentum dignissim. Fusce condimentum sagittis est a finibus. Suspendisse maximus semper quam vitae convallis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Fusce velit libero, ultrices ut nibh eget, sollicitudin pulvinar ipsum. Morbi interdum neque et orci ultricies ullamcorper. Proin a vulputate ante, nec semper nisi. Morbi bibendum leo vel bibendum cursus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Praesent ut est vel dolor porttitor consequat. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.  Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam vel iaculis augue. Pellentesque euismod nisi vitae elementum bibendum. Curabitur quis vulputate metus, sit amet egestas leo. Integer auctor sed nisi vitae rhoncus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nam id dui tortor. Aliquam vehicula lectus vitae quam interdum, in malesuada est sollicitudin. Aliquam eget justo felis.  Sed felis odio, vehicula sed enim vitae, dignissim luctus elit. Nulla pulvinar viverra ex ut ultrices. Duis et rutrum velit, et euismod lectus. Pellentesque quis ullamcorper ex. Duis metus sapien, lobortis non nunc id, placerat iaculis turpis. Nam id bibendum leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Proin posuere sapien at finibus dictum. Sed vitae ligula sollicitudin, molestie quam quis, vulputate lacus. Donec bibendum sollicitudin urna, id ornare augue. Morbi eu neque at metus pretium interdum quis eget libero. Phasellus condimentum nunc egestas urna auctor, a euismod dui elementum. Nulla mi quam, iaculis et suscipit et, sollicitudin ut magna. Ut tincidunt, libero et accumsan malesuada, tellus dui sagittis justo, vitae congue sapien erat ut dolor. Curabitur ac mauris quis augue facilisis vestibulum. \"\""
                                                                + "\r\n}"))
                                .andExpect(status().isBadRequest());

        }
}

/*
 * // To test getting planets by id
 * 
 * Planet planetWithId = Planet.builder()
 * .id(1L)
 * .name("Saturn")
 * .size(new BigDecimal(95.2))
 * .distance(new BigDecimal(9.6))
 * .description("It has rings.")
 * .build();
 * 
 * Planet planet = Planet.builder()
 * .name("Saturn")
 * .size(new BigDecimal(95.2))
 * .distance(new BigDecimal(9.6))
 * .description("It has rings.")
 * .build();
 * 
 * Mockito.when(planetService.savePlanet(planet))
 * .thenReturn(planetWithId);
 */
