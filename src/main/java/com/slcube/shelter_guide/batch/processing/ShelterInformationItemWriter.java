package com.slcube.shelter_guide.batch.processing;

import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationResultDataDto;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ShelterInformationItemWriter implements ItemWriter<List<SeoulShelterInformationResultDataDto>> {

    @Override
    public void write(List<? extends List<SeoulShelterInformationResultDataDto>> items) throws Exception {

    }
}
