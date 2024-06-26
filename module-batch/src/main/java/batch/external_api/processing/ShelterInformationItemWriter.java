package batch.external_api.processing;

import batch.external_api.mapper.ShelterInformationStagingMapper;
import domain.ShelterInformationStaging;
import external_api.dto.ShelterInformationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import repository.ShelterInformationStagingRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ShelterInformationItemWriter implements ItemWriter<List<ShelterInformationDto>> {

    private final ShelterInformationStagingRepository shelterInformationStagingRepository;

    @Override
    public void write(List<? extends List<ShelterInformationDto>> items) throws Exception {
        validationItems(items);
        items.forEach(item -> {
            List<ShelterInformationStaging> shelterInformationStagingList = item.stream()
                    .map(ShelterInformationStagingMapper::toEntity)
                    .collect(Collectors.toList());

            shelterInformationStagingRepository.saveAll(shelterInformationStagingList);
        });
    }

    private void validationItems(List<? extends List<ShelterInformationDto>> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items can not be null");
        }
    }
}
