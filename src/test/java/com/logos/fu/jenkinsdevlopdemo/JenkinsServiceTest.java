package com.logos.fu.jenkinsdevlopdemo;

import com.cdancy.jenkins.rest.domain.common.RequestStatus;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JenkinsServiceTest {

    @Autowired
    private JenkinsService jenkinsService;
    String xml = "<?xml version='1.1' encoding='UTF-8'?>\n" +
            "<flow-definition plugin=\"workflow-job@1145.v7f2433caa07f\">\n" +
            "  <description/>\n" +
            "  <keepDependencies>false</keepDependencies>\n" +
            "  <properties/>\n" +
            "  <definition class=\"org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition\" plugin=\"workflow-cps@2659.v52d3de6044d0\">\n" +
            "    <script/>\n" +
            "    <sandbox>true</sandbox>\n" +
            "  </definition>\n" +
            "  <triggers/>\n" +
            "  <disabled>false</disabled>\n" +
            "</flow-definition>";


    @Test
    @Order(1)
    void should_create_jenkins_job() {

        RequestStatus job = jenkinsService.createJob("test", xml);
        assertThat(job.value()).isTrue();
    }

    @Test
    @Order(2)
    void should_return_xml_from_jenkins() {
        String jobInfo = jenkinsService.getJobInfo("test");
        assertThat(jobInfo.replaceAll("\n", "").replaceAll("'", "").replaceAll("\"", ""))
                .isEqualTo(
                        xml.replaceAll("\n", "").replaceAll("'", "")
                                .replaceAll("\"", ""));
    }
}