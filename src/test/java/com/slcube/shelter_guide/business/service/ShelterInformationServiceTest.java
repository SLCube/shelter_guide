package com.slcube.shelter_guide.business.service;

import com.slcube.shelter_guide.business.dto.ShelterInformationListResponseDto;
import com.slcube.shelter_guide.business.dto.ShelterInformationResponseDto;
import com.slcube.shelter_guide.business.entity.ShelterInformation;
import com.slcube.shelter_guide.business.repository.ShelterInformationRepository;
import com.slcube.shelter_guide.common.exception.NotFoundShelterInformation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
public class ShelterInformationServiceTest {

    @InjectMocks
    private ShelterInformationService shelterInformationService;

    @Mock
    private ShelterInformationRepository shelterInformationRepository;

    @Test
    void 대피소_정보_단건_조회_테스트() {
        ShelterInformationResponseDto responseDto = createShelterInformationResponseDto();
        ShelterInformation shelterInformation = createShelterInformation();

        given(shelterInformationRepository.findById(anyLong()))
                .willReturn(Optional.ofNullable(shelterInformation));

        assertThat(shelterInformationService.findById(1L))
                .isEqualTo(responseDto);
    }

    @Test
    void 대피소_정보_다건_조회_테스트() {
        List<ShelterInformationListResponseDto> shelterInformationListResponseDtoList = createShelterInformationResponseDtoList();
        List<ShelterInformation> shelterInformationList = List.of(createShelterInformation());

        given(shelterInformationRepository.findByDistrict(anyString()))
                .willReturn(shelterInformationList);

        assertThat(shelterInformationService.findShelterInformation("구로구 고척동"))
                .isEqualTo(shelterInformationListResponseDtoList);
    }

    @Test
    void 대피소_정보가_없을_때_테스트() {
        given(shelterInformationRepository.findById(anyLong()))
                .willReturn(Optional.empty());

        assertThatThrownBy(() -> shelterInformationService.findById(1L))
                .isInstanceOf(NotFoundShelterInformation.class);
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

    private ShelterInformation createShelterInformation() {
        ShelterInformation shelterInformation = ShelterInformation.builder()
                .managementNumber("3160000-S202300004")
                .licenseDate("2023-07-13")
                .businessStatusCode("01")
                .businessStatusName("영업/정상")
                .detailedBusinessStatusCode("18")
                .detailedBusinessStatusName("사용중")
                .positionX(187473.221837261)
                .positionY(444729.961384482)
                .locationArea(15666)
                .landNumberAddress("서울특별시 구로구 고척동 342 벽산베스트블루밍아파트")
                .roadNameAddress("서울특별시 구로구 고척로60길 30, 지하1~2층 (고척동, 벽산베스트블루밍아파트)")
                .roadNamePostalCode("08228")
                .build();
        setField(shelterInformation, "id", 1L);
        return shelterInformation;
    }
}
