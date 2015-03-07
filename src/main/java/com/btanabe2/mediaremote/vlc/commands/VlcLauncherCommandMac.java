package com.btanabe2.mediaremote.vlc.commands;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcLauncherCommandMac implements VlcLauncherCommand {

    public VlcLauncherCommandMac(String vlcExecutablePath) {

    }

    @Override
    public String getVlcLaunchCommand() {
        return "mac";
    }
}
