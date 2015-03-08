package test.integration;

import org.junit.Test;
import test.fixtures.VlcCommandLineFixtures;
import test.helpers.MacOsDependentTestClass;
import vlc.commands.VlcLauncherCommandMac;
import vlc.launcher.VlcLauncher;

import static org.junit.Assert.fail;
import static test.fixtures.PathFixtures.TEST_MOVIE_FILE_PATH;
import static test.fixtures.PathFixtures.TEST_VLC_EXECUTABLE_PATH;

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
