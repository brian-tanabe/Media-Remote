package com.btanabe2.mediaremote.test.unit;

import com.btanabe2.mediaremote.vlc.commands.VlcLauncherCommandMac;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcLauncherCommandMacTests {

    @Test
    public void shouldBeAbleToIssueTheProperVlcLaunchCommand() {
        VlcLauncherCommandMac launcher = new VlcLauncherCommandMac("/Applications/VLC.app/Contents/MacOS/VLC");
        assertEquals("Did not generate the correct VLC executable command", "./Applications/VLC.app/Contents/MacOS/VLC -vvv ~/Downloads/Wet\\ Hot\\ American\\ Summer.m4v --fullscreen", launcher.getVlcLaunchCommand());
    }
}
