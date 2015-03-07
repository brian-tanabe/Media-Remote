package com.btanabe2.mediaremote.test.integration;

import com.btanabe2.mediaremote.test.fixtures.PathFixtures;
import com.btanabe2.mediaremote.vlc.commands.VlcLauncherCommandMac;
import com.btanabe2.mediaremote.vlc.launcher.VlcLauncher;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcLauncherTests {

    @Test
    public void shouldBeAbleToLaunchVlc() {
        try {
            VlcLauncher.playVideoFile(new VlcLauncherCommandMac(PathFixtures.TEST_VLC_EXECUTABLE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
            fail("Failed to execute test process");
        }
    }
}
