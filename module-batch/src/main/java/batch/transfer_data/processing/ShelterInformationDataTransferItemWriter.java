package batch.transfer_data.processing;

import batch.transfer_data.mapper.ShelterInformationMapper;
import domain.ShelterInformation;
import domain.ShelterInformationStaging;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import repository.ShelterInformationRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ShelterInformationDataTransferItemWriter implements ItemWriter<List<ShelterInformationStaging>> {

    private final ShelterInformationRepository shelterInformationRepository;
    @Override
    public void write(List<? extends List<ShelterInformationStaging>> items) throws Exception {
        validationItems(items);
        items.forEach(item -> {
            List<ShelterInformation> shelterinformationList = item.stream().map(ShelterInformationMapper::toEntity)
                    .collect(Collectors.toList());

            shelterInformationRepository.saveAll(shelterinformationList);
        });
    }

    private void validationItems(List<? extends List<ShelterInformationStaging>> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items can not be null");
        }
    }
}
