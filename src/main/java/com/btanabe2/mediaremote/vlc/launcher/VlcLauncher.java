package com.btanabe2.mediaremote.vlc.launcher;

import com.btanabe2.mediaremote.vlc.commands.VlcLauncherCommand;

import java.io.IOException;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcLauncher {

    public static void playVideoFile(VlcLauncherCommand launcherCommand) throws IOException, InterruptedException {
        try {
            Process process = Runtime.getRuntime().exec(launcherCommand.getVlcLaunchCommand());
            process.exitValue();
        } catch (IllegalThreadStateException ex) {
            if(!ex.getMessage().equals("process hasn't exited")) {
                throw ex;
            }
        }
    }
}
