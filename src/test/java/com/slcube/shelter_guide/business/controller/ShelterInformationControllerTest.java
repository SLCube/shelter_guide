package com.slcube.shelter_guide.business.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slcube.shelter_guide.business.dto.ShelterInformationListResponseDto;
import com.slcube.shelter_guide.business.dto.ShelterInformationResponseDto;
import com.slcube.shelter_guide.business.service.ShelterInformationService;
import com.slcube.shelter_guide.common.exception.NotFoundShelterInformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ShelterInformationController.class)
public class ShelterInformationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ShelterInformationService shelterInformationService;


    @Test
    void 대피소_정보_다건_조회_테스트() throws Exception {
        List<ShelterInformationListResponseDto> responseDtoList = createShelterInformationResponseDtoList();

        given(shelterInformationService.findShelterInformation(anyString()))
                .willReturn(responseDtoList);

        mockMvc.perform(get("/api/shelter-information")
                        .param("district", "강남구 압구정동"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(responseDtoList)))
                .andDo(print());
    }

    @Test
    void 대피소_정보_단건_조회_테스트() throws Exception {

        ShelterInformationResponseDto responseDto = createShelterInformationResponseDto();

        given(shelterInformationService.findById(anyLong()))
                .willReturn(responseDto);

        mockMvc.perform(get("/api/shelter-information/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(responseDto)))
                .andDo(print());

    }

    @Test
    void 대피소_정보_단건_조회시_대피소_정보가_없을_때_테스트() throws Exception {
        given(shelterInformationService.findById(anyLong()))
                .willThrow(new NotFoundShelterInformation());

        mockMvc.perform(get("/api/shelter-information/{id}", 1L))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    private ShelterInformationResponseDto createShelterInformationResponseDto() {
        ShelterInformationResponseDto responseDto = new ShelterInformationResponseDto();

        setField(responseDto, "shelterInformationId", 1L);
        setField(responseDto, "managementNumber", "3160000-S202300004");
        setField(responseDto, "licenseDate", "2023-07-13");
        setField(responseDto, "businessStatusCode", "01");
        setField(responseDto, "businessStatusName", "영업/정상");
        setField(responseDto, "detailedBusinessStatusCode", "18");
        setField(responseDto, "detailedBusinessStatusName", "사용중");
        setField(responseDto, "positionX", 187473.221837261);
        setField(responseDto, "positionY", 444729.961384482);
        setField(responseDto, "locationArea", 15666);
        setField(responseDto, "landNumberAddress", "서울특별시 구로구 고척동 342 벽산베스트블루밍아파트");
        setField(responseDto, "roadNameAddress", "서울특별시 구로구 고척로60길 30, 지하1~2층 (고척동, 벽산베스트블루밍아파트)");
        setField(responseDto, "roadNamePostalCode", "08228");

        return responseDto;
    }

    private List<ShelterInformationListResponseDto> createShelterInformationResponseDtoList() {
        List<ShelterInformationListResponseDto> responseDtoList = new ArrayList<>();

        ShelterInformationListResponseDto responseDto = new ShelterInformationListResponseDto();
        setField(responseDto, "shelterInformationId", 1L);
        setField(responseDto, "managementNumber", "3160000-S202300004");
        setField(responseDto, "businessStatusCode", "01");
        setField(responseDto, "businessStatusName", "영업/정상");
        setField(responseDto, "detailedBusinessStatusCode", "18");
        setField(responseDto, "detailedBusinessStatusName", "사용중");
        setField(responseDto, "landNumberAddress", "서울특별시 구로구 고척동 342 벽산베스트블루밍아파트");
        setField(responseDto, "roadNameAddress", "서울특별시 구로구 고척로60길 30, 지하1~2층 (고척동, 벽산베스트블루밍아파트)");
        setField(responseDto, "roadNamePostalCode", "08228");

        responseDtoList.add(responseDto);

        return responseDtoList;
    }
}
