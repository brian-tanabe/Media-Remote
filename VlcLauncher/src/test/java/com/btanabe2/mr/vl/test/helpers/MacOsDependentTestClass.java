package com.btanabe2.mr.vl.test.helpers;

import org.junit.BeforeClass;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 3/6/15.
 */
public class MacOsDependentTestClass {

    @BeforeClass
    public static void verifyMacOsOperatingSystem() {
        assertThat("This test needs to be run on OS X", System.getProperty("os.name"), containsString("Mac OS X"));
    }
}
