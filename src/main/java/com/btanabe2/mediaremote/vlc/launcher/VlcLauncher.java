package com.btanabe2.mediaremote.vlc.launcher;

import com.btanabe2.mediaremote.vlc.commands.VlcLauncherCommand;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcLauncher {

    public static String playVideoFile(VlcLauncherCommand launcherCommand) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(launcherCommand.getVlcLaunchCommand());
        process.waitFor();

        StringWriter writer = new StringWriter();
        IOUtils.copy(process.getInputStream(), writer);
        return IOUtils.toString(process.getInputStream());
    }
}
