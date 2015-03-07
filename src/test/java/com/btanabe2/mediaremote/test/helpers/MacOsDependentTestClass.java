package com.btanabe2.mediaremote.test.helpers;

import org.junit.BeforeClass;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 3/6/15.
 */
public class MacOsDependentTestClass {

    @BeforeClass
    public static void verifyMacOsOperatingSystem() {
        String operatingSystemString = System.getProperty("os.name");
        assertThat("This test needs to be run on OS X", operatingSystemString, containsString("Mac OS X"));
    }
}
