package com.slcube.shelter_guide.batch.integrate_test;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.external_api.repository.ShelterInformationStagingRepository;
import com.slcube.shelter_guide.batch.external_api.util.RegionConstant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.*;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static com.slcube.shelter_guide.batch.external_api.util.RegionConstant.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBatchTest
@SpringBootTest
class ShelterInformationJobIntegrateTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private JobRepositoryTestUtils jobRepositoryTestUtils;

    @Autowired
    private ShelterInformationStagingRepository shelterInformationStagingRepository;

    @AfterEach
    void afterEach() {
        jobRepositoryTestUtils.removeJobExecutions();
    }

    @Test
    void 서울시_대피소_api호출_batch_통합테스트() throws Exception {
        fetchShelterInformationFromExternalApiTest(SEOUL);
    }

    @Test
    void 인천_대피소_api호출_batch_통합테스트() throws Exception {
        fetchShelterInformationFromExternalApiTest(INCHEON);
    }

    @Test
    void 광주_대피소_api호출_batch_통합테스트() throws Exception {
        fetchShelterInformationFromExternalApiTest(GWANG_JU);
    }

    @Test
    void 경기도_대피소_api호출_batch_통합테스트() throws Exception {
        fetchShelterInformationFromExternalApiTest(GYEONG_GI);
    }

    @Test
    void 충청남도_대피소_api호출_batch_통합테스트() throws Exception {
        fetchShelterInformationFromExternalApiTest(CHUNG_CHEONG_NAM_DO);
    }

    @Test
    void 전라북도_대피소_api호출_batch_통합테스트() throws Exception {
        fetchShelterInformationFromExternalApiTest(JEOLLA_BUK_DO);
    }

    @Test
    void 전라남도_대피소_api호출_batch_통합테스트() throws Exception {
        fetchShelterInformationFromExternalApiTest(JEOLLA_NAM_DO);
    }

    @Test
    void 경상남도_대피소_api호출_batch_통합테스트() throws Exception {
        fetchShelterInformationFromExternalApiTest(GYEONG_SANG_BUK_DO);
    }

    @Test
    void 대전광역시_대피소_api호출_batch_통합테스트() throws Exception {
        fetchShelterInformationFromExternalApiTest(DAE_JEON);
    }

    private void fetchShelterInformationFromExternalApiTest(RegionConstant region) throws Exception {
        LocalDateTime thursday = LocalDateTime.of(
                2023,
                7,
                20,
                15,
                13
        );

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("region", region.getRegion())
                .addString("datetime", thursday.toString())
                .toJobParameters();

        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

        List<ShelterInformationStaging> shelterInformationStagingList = shelterInformationStagingRepository.findAll();

        assertThat(jobExecution.getStatus()).isEqualTo(BatchStatus.COMPLETED);
        assertThat(jobExecution.getExitStatus()).isEqualTo(ExitStatus.COMPLETED);
        assertThat(shelterInformationStagingList).isNotEmpty();
    }
}
