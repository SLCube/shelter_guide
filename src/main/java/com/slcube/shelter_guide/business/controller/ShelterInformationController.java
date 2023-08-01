package com.slcube.shelter_guide.business.controller;

import com.slcube.shelter_guide.business.dto.ShelterInformationListResponseDto;
import com.slcube.shelter_guide.business.dto.ShelterInformationResponseDto;
import com.slcube.shelter_guide.business.service.ShelterInformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation
    @ApiResponses({})
    @Parameters({})
    @GetMapping
    public List<ShelterInformationListResponseDto> findShelterInformationList(@RequestParam @NotBlank String address) {
        return shelterInformationService.findShelterInformation(address);
    }


    @Operation
    @ApiResponses({})
    @Parameters({})
    @GetMapping("/{id}")
    public ShelterInformationResponseDto findShelterInformation(@PathVariable @Min(1) Long id) {
        return shelterInformationService.findById(id);
    }
}
