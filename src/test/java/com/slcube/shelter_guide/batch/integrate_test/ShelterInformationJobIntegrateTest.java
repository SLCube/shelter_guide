package com.slcube.shelter_guide.batch.integrate_test;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.external_api.repository.ShelterInformationStagingRepository;
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

import static com.slcube.shelter_guide.batch.external_api.util.RegionConstant.GYEONG_GI;
import static com.slcube.shelter_guide.batch.external_api.util.RegionConstant.SEOUL;
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
        LocalDateTime thursday = LocalDateTime.of(
                2023,
                7,
                20,
                15,
                13
        );

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("region", SEOUL.getRegion())
                .addString("datetime", thursday.toString())
                .toJobParameters();

        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

        List<ShelterInformationStaging> shelterInformationStagingList = shelterInformationStagingRepository.findAll();

        assertThat(jobExecution.getStatus()).isEqualTo(BatchStatus.COMPLETED);
        assertThat(jobExecution.getExitStatus()).isEqualTo(ExitStatus.COMPLETED);
        assertThat(shelterInformationStagingList).isNotEmpty();
    }

    @Test
    void 경기도_대피소_api호출_batch_통합테스트() throws Exception {
        LocalDateTime thursday = LocalDateTime.of(
                2023,
                7,
                20,
                15,
                13
        );

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("region", GYEONG_GI.getRegion())
                .addString("datetime", thursday.toString())
                .toJobParameters();

        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

        List<ShelterInformationStaging> shelterInformationStagingList = shelterInformationStagingRepository.findAll();

        assertThat(jobExecution.getStatus()).isEqualTo(BatchStatus.COMPLETED);
        assertThat(jobExecution.getExitStatus()).isEqualTo(ExitStatus.COMPLETED);
        assertThat(shelterInformationStagingList).isNotEmpty();
    }
}
