package com.btanabe2.mediaremote.vlc.launcher;

import com.btanabe2.mediaremote.vlc.commands.VlcLauncherCommand;

import java.io.IOException;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcLauncher {

    public static String playVideoFile(VlcLauncherCommand launcherCommand) throws IOException, InterruptedException {
        System.out.println(String.format("Running: [%s]", launcherCommand.getVlcLaunchCommand()));

//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        Thread videoThread = new Thread(new VlcVideoThread(launcherCommand));
//        videoThread.start();

        Process process = Runtime.getRuntime().exec(launcherCommand.getVlcLaunchCommand());
        System.out.println("Wait for time: " + process.waitFor());

        System.out.println("Thread running");

        return "";
    }

    private static class VlcVideoThread implements Runnable {
        private VlcLauncherCommand launcherCommand;

        public VlcVideoThread(VlcLauncherCommand launcherCommand) {
            this.launcherCommand = launcherCommand;
        }

        @Override
        public void run() {
            try {
                Process process = Runtime.getRuntime().exec(launcherCommand.getVlcLaunchCommand());
                System.out.println("Wait for time: " + process.waitFor());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
