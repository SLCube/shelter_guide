package batch.external_api.service;

import batch.external_api.dto.ShelterInformationDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

public interface ShelterInformationApiService {
    List<ShelterInformationDto> fetchShelterInformation(int pageNo, int pageSize) throws MalformedURLException, URISyntaxException, JsonProcessingException;
}
