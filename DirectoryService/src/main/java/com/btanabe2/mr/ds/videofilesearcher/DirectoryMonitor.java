package com.btanabe2.mr.ds.videofilesearcher;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

import java.io.File;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Brian on 3/7/15.
 */
public class DirectoryMonitor {

    public void monitorDirectories(List<File> videoStore, VideoFileExtensionFilter fileFilter, File... directoriesToMonitor) {
        setUpDirectoryMonitors(directoriesToMonitor);
        performInitialScanOfDirectories(videoStore, fileFilter, directoriesToMonitor);
    }

    private void setUpDirectoryMonitors(File... directoriesToMonitor) {

    }

    private void performInitialScanOfDirectories(List<File> videoStore, VideoFileExtensionFilter fileFilter, File... directoriesToMonitor) {
        Stream.of(directoriesToMonitor).forEach(d -> scanDirectory(videoStore, d, fileFilter));
    }

    private void scanDirectory(List<File> videoStore, File directory, VideoFileExtensionFilter fileFilter) {
        videoStore.addAll(FileUtils.listFiles(directory, new IOFileFilter() {
            @Override
            public boolean accept(File file) {  // file filter
                return fileFilter.getFilterExtensionStringArray().contains(FilenameUtils.getExtension(file.getName()));
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
