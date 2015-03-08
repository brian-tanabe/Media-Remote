package vlc.commands;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcLauncherCommandWindows implements VlcLauncherCommand {

    public VlcLauncherCommandWindows(String vlcExecutablePath) {

    }

    @Override
    public String getVlcLaunchCommand() {
        return "windows";
    }
}
