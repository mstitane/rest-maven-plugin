package com.stitane.plugin.tests.rest;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.stitane.rest.plugin.RestPlugin;

public class RestPluginTest
        extends AbstractMojoTestCase {

    /**
     * {@inheritDoc}
     *
     * @throws java.lang.Exception
     */
    @Override
    protected void setUp()
            throws Exception {
        try {
            // required
            super.setUp();

        } catch (InvocationTargetException ex) {
            System.out.println("oops!" + ex.getCause().toString());
        }
    }

    /**
     * {@inheritDoc}
     *
     * @throws java.lang.Exception
     */
    @Override
    protected void tearDown()
            throws Exception {
        try {
            // required
            super.tearDown();
        } catch (InvocationTargetException ex) {
            System.out.println("oops!" + ex.getCause().toString());
        }

    }

    /**
     * @return
     * @throws Exception if any
     */
    protected RestPlugin loadPlugin()
            throws Exception {
        File pom = getTestFile("src/test/resources/unit/rest-project/pom.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        RestPlugin myPlugin = (RestPlugin) lookupMojo("rest-request", pom);
        return myPlugin;
    }

    /**
     * @throws Exception if any
     */
    public void testEndpoint()
            throws Exception {
        try {
            RestPlugin myPlugin = loadPlugin();
            String url="http://perf1.opencellsoft.com:8886";
            assertNotNull("Null Plugin", myPlugin);
            assertNotNull("Null", myPlugin.getEndpoint());
            assertTrue("Expected [" + url + "] Not equal to:[" +
                       myPlugin.getEndpoint().toString() + "]",
                       myPlugin.getEndpoint().toString().equals(url));
        } catch (InvocationTargetException ex) {
            System.out.println("oops!" + ex.getCause().toString());
        }
    }
    /**
     * @throws Exception if any
     */
    public void testFileset()
            throws Exception {
        try {
            RestPlugin myPlugin = loadPlugin();
            assertNotNull("Null Plugin", myPlugin);
            assertNotNull("Null Fileset", myPlugin.getFileset());
        } catch (InvocationTargetException ex) {
            System.out.println("oops!" + ex.getCause().toString());
        }

    }
    /**
     * @throws Exception if any
     */
    public void testSaveResponse()
            throws Exception {
        try {
            RestPlugin myPlugin = loadPlugin();
            assertNotNull("Null Plugin", myPlugin);
            assertNotNull("Null save response", myPlugin.getSaveResponse());
            assertFalse("save response is false", myPlugin.getSaveResponse());
        } catch (InvocationTargetException ex) {
            System.out.println("oops!" + ex.getCause().toString());
        }
    }
    /**
     * @throws Exception if any
     */
    public void testConvertJavaFiles()
            throws Exception {
        try {
            RestPlugin myPlugin = loadPlugin();
            assertNotNull("Null Plugin", myPlugin);
            myPlugin.execute();
        } catch (InvocationTargetException ex) {
            System.out.println("oops!" + ex.getCause().toString());
        }
    }
}
