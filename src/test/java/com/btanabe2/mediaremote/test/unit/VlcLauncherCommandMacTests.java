package com.btanabe2.mediaremote.test.unit;

import com.btanabe2.mediaremote.test.fixtures.VlcCommandLineFixtures;
import com.btanabe2.mediaremote.vlc.commands.VlcLauncherCommandMac;
import org.junit.Test;

import static com.btanabe2.mediaremote.test.fixtures.PathFixtures.TEST_MOVIE_FILE_PATH;
import static com.btanabe2.mediaremote.test.fixtures.PathFixtures.TEST_VLC_EXECUTABLE_PATH;
import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcLauncherCommandMacTests {

    @Test
    public void shouldBeAbleToFormatTheVlcLauncherCommandForOsxProperly() {
        VlcLauncherCommandMac launcher = new VlcLauncherCommandMac(TEST_VLC_EXECUTABLE_PATH, VlcCommandLineFixtures.getVlcCommandLineArgumentsForVideoFile(TEST_MOVIE_FILE_PATH));
        assertEquals("Did not generate the correct VLC executable command", String.format("%s --fullscreen -vvv %s", TEST_VLC_EXECUTABLE_PATH, TEST_MOVIE_FILE_PATH), launcher.getVlcLaunchCommand());
    }
}
