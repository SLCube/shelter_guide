package batch.config;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.util.Assert;

import java.util.HashMap;

public class VersionJobParametersIncrementer implements JobParametersIncrementer {
    @Override
    public JobParameters getNext(JobParameters parameters) {
        Assert.notNull(parameters, "parameters can not be null");
        HashMap<String, JobParameter> params = new HashMap<>(parameters.getParameters());
        params.put("version", new JobParameter(System.currentTimeMillis()));
        return new JobParameters(params);
    }
}
