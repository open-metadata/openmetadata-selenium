package org.openmetadata.selenium.operation;

import org.openmetadata.selenium.properties.Property;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class StartServerAndIngestSampleData {
    public static final String PATH = Property.getInstance().getPath();
    private static final Logger LOG = Logger.getLogger(StartServerAndIngestSampleData.class.getName());

    public static void mvnPackage() throws IOException, InterruptedException {
        String[] mvnPackage = {"bash", "-c", "cd " + '"' + PATH + '"' + "&& mvn -DskipTests clean package"};
        Process processMvnPackage = Runtime.getRuntime().exec(mvnPackage);
        processMvnPackage.waitFor();
        LOG.info("Maven Package Done");
    }

    public static void runDocker() throws IOException, InterruptedException {
        String[] runDocker = {"bash", "-c", "cd " + '"' + PATH + '"' + "/docker/local-metadata " + "&& docker-compose up"};
        Process processRunDocker = Runtime.getRuntime().exec(runDocker);
        processRunDocker.waitFor(5, TimeUnit.MINUTES);
        LOG.info("Docker Up and Running");
    }
}
