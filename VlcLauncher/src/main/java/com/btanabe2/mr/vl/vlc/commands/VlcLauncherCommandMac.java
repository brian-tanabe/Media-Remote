package com.btanabe2.mr.vl.vlc.commands;

import java.util.Map;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcLauncherCommandMac implements VlcLauncherCommand {
    private String vlcExecutablePath;
    private Map<String, String> vlcCommandLineArgumentsMap;

    public VlcLauncherCommandMac(String vlcExecutablePath, Map<String, String> vlcCommandLineArguments) {
        this.vlcExecutablePath = vlcExecutablePath;
        this.vlcCommandLineArgumentsMap = vlcCommandLineArguments;
    }

    @Override
    public String getVlcLaunchCommand() {
        return String.format("%s %s", vlcExecutablePath, stringifyArgumentMap(vlcCommandLineArgumentsMap));
    }

    private static String stringifyArgumentMap(Map<String, String> vlcCommandLineArgumentsMap) {
        final StringBuilder argumentString = new StringBuilder();
        vlcCommandLineArgumentsMap.keySet().forEach(k -> argumentString.append(String.format("-%s %s ", k, vlcCommandLineArgumentsMap.get(k))));
        return argumentString.toString().trim();
    }
}
