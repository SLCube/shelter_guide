package com.slcube.shelter_guide.common.config.batch;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersIncrementer;

import java.util.HashMap;

public class VersionJobParametersIncrementer implements JobParametersIncrementer {
    @Override
    public JobParameters getNext(JobParameters parameters) {
        HashMap<String, JobParameter> params = new HashMap<>(parameters.getParameters());
        params.put("version", new JobParameter(System.currentTimeMillis()));
        return new JobParameters(params);
    }
}
