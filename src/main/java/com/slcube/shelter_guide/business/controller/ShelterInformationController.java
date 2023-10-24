package com.slcube.shelter_guide.business.controller;

import com.slcube.shelter_guide.business.dto.ShelterInformationListResponseDto;
import com.slcube.shelter_guide.business.dto.ShelterInformationResponseDto;
import com.slcube.shelter_guide.business.service.ShelterInformationService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/api/shelter-information")
@RequiredArgsConstructor
public class ShelterInformationController {

    private final ShelterInformationService shelterInformationService;

    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ShelterInformationListResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(mediaType = "application/json"))
    @Parameter(name = "district", description = "동", example = "강남구 압구정")
    @GetMapping
    public List<ShelterInformationListResponseDto> findShelterInformationList(
            @RequestParam @NotBlank(message = "주소 정보는 필수 입력 항목 입니다.") String district) {
        return shelterInformationService.findShelterInformation(district);
    }


    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ShelterInformationResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(mediaType = "application/json"))
    @GetMapping("/{id}")
    public ShelterInformationResponseDto findShelterInformation(
            @PathVariable @Min(value = 1, message = "id값은 최소 1이상의 값을 입력해주세요.") Long id) {
        return shelterInformationService.findById(id);
    }
}
