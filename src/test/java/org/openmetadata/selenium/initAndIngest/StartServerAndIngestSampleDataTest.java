package org.openmetadata.selenium.initAndIngest;

import org.openmetadata.selenium.operation.StartServerAndIngestSampleData;
import org.testng.annotations.Test;

import java.io.IOException;

public class StartServerAndIngestSampleDataTest {

    // RUN THIS TEST FIRST

    @Test
    public void startServer() throws IOException, InterruptedException {
        StartServerAndIngestSampleData.mvnPackage();
        StartServerAndIngestSampleData.runDocker();
    }
}
