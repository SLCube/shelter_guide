package com.slcube.shelter_guide.batch.processing;

import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationDto;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ShelterInformationItemWriter implements ItemWriter<SeoulShelterInformationDto> {

    @Override
    public void write(List<? extends SeoulShelterInformationDto> items) throws Exception {

    }
}
