package com.btanabe2.mr.vl.test.integration;

import com.btanabe2.mr.vl.test.fixtures.VlcCommandLineFixtures;
import com.btanabe2.mr.vl.test.helpers.MacOsDependentTestClass;
import com.btanabe2.mr.vl.vlc.commands.VlcLauncherCommandMac;
import com.btanabe2.mr.vl.vlc.launcher.VlcLauncher;
import org.junit.Test;

import static com.btanabe2.mr.vl.test.fixtures.PathFixtures.TEST_MOVIE_FILE_PATH;
import static com.btanabe2.mr.vl.test.fixtures.PathFixtures.TEST_VLC_EXECUTABLE_PATH;
import static org.junit.Assert.fail;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcLauncherTests extends MacOsDependentTestClass {

    @Test
    public void shouldBeAbleToLaunchVlc() {
        try {
            VlcLauncher.playVideoFile(new VlcLauncherCommandMac(TEST_VLC_EXECUTABLE_PATH, VlcCommandLineFixtures.getVlcCommandLineArgumentsForVideoFile(TEST_MOVIE_FILE_PATH)));
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to execute test process");
        }
    }
}
