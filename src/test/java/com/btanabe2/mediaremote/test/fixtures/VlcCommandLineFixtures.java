package com.btanabe2.mediaremote.test.fixtures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcCommandLineFixtures {

    public static Map<String, String> getVlcCommandLineArgumentsForVideoFile(String videoFilePath) {
        Map<String, String> commandLineArgumentMap = new HashMap<String, String>();
        commandLineArgumentMap.put("-fullscreen", "");
        commandLineArgumentMap.put("vvv", videoFilePath);
        return commandLineArgumentMap;
    }
}
