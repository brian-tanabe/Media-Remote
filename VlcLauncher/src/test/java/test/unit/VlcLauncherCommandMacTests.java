package test.unit;

import org.junit.Test;
import test.fixtures.VlcCommandLineFixtures;
import vlc.commands.VlcLauncherCommandMac;

import static junit.framework.TestCase.assertEquals;
import static test.fixtures.PathFixtures.TEST_MOVIE_FILE_PATH;
import static test.fixtures.PathFixtures.TEST_VLC_EXECUTABLE_PATH;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcLauncherCommandMacTests {

    @Test
    public void shouldBeAbleToFormatTheVlcLauncherCommandForOsxProperly() {
        VlcLauncherCommandMac launcher = new VlcLauncherCommandMac(TEST_VLC_EXECUTABLE_PATH, VlcCommandLineFixtures.getVlcCommandLineArgumentsForVideoFile(TEST_MOVIE_FILE_PATH));
        assertEquals("Did not generate the correct VLC executable command", String.format("%s -vvv %s --fullscreen", TEST_VLC_EXECUTABLE_PATH, TEST_MOVIE_FILE_PATH), launcher.getVlcLaunchCommand());
    }
}
