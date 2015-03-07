package com.btanabe2.mediaremote.vlc.launcher;

import com.btanabe2.mediaremote.vlc.commands.VlcLauncherCommand;

import java.io.*;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcLauncher {

    public static void playVideoFile(VlcLauncherCommand launcherCommand) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("time");
        process.waitFor();

//        Process tr = Runtime.getRuntime().exec( new String[]{ "cat" } );
        Writer wr = new OutputStreamWriter( process.getOutputStream() );
        BufferedReader rd = new BufferedReader( new InputStreamReader( process.getInputStream() ) );
        wr.write( "hello, world\n" );
        wr.flush();
        String s = rd.readLine();
        System.out.println( s );
    }
}
