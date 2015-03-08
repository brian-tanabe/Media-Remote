package com.btanabe2.mr.ds.videofilesearcher;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

import java.io.File;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Brian on 3/7/15.
 */
public class DirectoryMonitor {
    private List<File> directoriesToMonitor;

    public void monitorDirectories(List<File> videoStore, File... directoriesToMonitor) {
        setUpDirectoryMonitors(directoriesToMonitor);
        performInitialScanOfDirectories(videoStore, directoriesToMonitor);
    }

    private void setUpDirectoryMonitors(File... directoriesToMonitor) {

    }

    private void performInitialScanOfDirectories(List<File> videoStore, File... directoriesToMonitor) {
        Stream.of(directoriesToMonitor).forEach(d -> scanDirectory(videoStore, d));
    }

    private void scanDirectory(List<File> videoStore, File directory) {
        videoStore.addAll(FileUtils.listFiles(directory, new IOFileFilter() {
            @Override
            public boolean accept(File file) {  // file filter
                return true;
            }

            @Override
            public boolean accept(File dir, String name) {
                return true;
            }
        }, new IOFileFilter() { // directory filter
            @Override
            public boolean accept(File file) {
                return true;
            }

            @Override
            public boolean accept(File dir, String name) {
                return true;
            }
        }));
    }
}
