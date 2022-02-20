package com.logos.fu.jenkinsdevlopdemo;

import com.cdancy.jenkins.rest.JenkinsClient;
import com.cdancy.jenkins.rest.domain.common.RequestStatus;
import org.springframework.stereotype.Service;

@Service
public class JenkinsService {

    private final JenkinsClient jenkinsClient;

    public JenkinsService(JenkinsClient jenkinsClient) {
        this.jenkinsClient = jenkinsClient;
    }

    public RequestStatus createJob(String name, String xml) {

        return jenkinsClient.api().jobsApi().create(null, name, xml);
    }

    public String getJobInfo(String jobName) {
        return jenkinsClient.api().jobsApi().config("", jobName);
    }
}
