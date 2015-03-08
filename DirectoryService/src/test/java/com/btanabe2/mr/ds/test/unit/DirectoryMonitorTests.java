package com.btanabe2.mr.ds.test.unit;

import com.btanabe2.mr.ds.videofilesearcher.DirectoryMonitor;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 3/7/15.
 */
public class DirectoryMonitorTests {
    private DirectoryMonitor monitor;
    private List<File> videoFileList;

    @Before
    public void createNewTestEnvironment() {
        videoFileList = new ArrayList<>();
        monitor = new DirectoryMonitor();
    }

    @Test
    public void shouldBeAbleToFindOneFileInOneDirectory() {
        monitor.monitorDirectories(videoFileList, new File("./DirectoryService/src/test/resources/test-video-directory/single-file/"));
        assertThat(videoFileList, hasItems(new File("./DirectoryService/src/test/resources/test-video-directory/single-file/Whiplash.2014.720p.WEB-DL.AAC2.0.H264-BHD.mkv")));
    }

    @Test
    public void shouldBeAbleToFindMultipleFilesInOneDirectory() {
        monitor.monitorDirectories(videoFileList, new File("./DirectoryService/src/test/resources/test-video-directory/multiple-files/"));
        assertThat(videoFileList, hasItems(new File("./DirectoryService/src/test/resources/test-video-directory/multiple-files/What.We.Do.In.The.Shadows.2014.HDRip.x264-COX.mkv"), new File("./DirectoryService/src/test/resources/test-video-directory/multiple-files/Standby.2014.720p.WEB-DL.x264.AC3-iFT.mkv")));
    }

    @Test
    public void shouldBeAbleToFindSingleFilesInOneSubdirectory() {

    }

    @Test
    public void shouldBeAbleToFindVideoFilesCompressedAndSplitAsRarFiles() {

    }

    @Test
    public void shouldBeAbleToExcludeNonVideoFiles() {

    }

    @Test
    public void shouldBeAbleToFindNewlyCreatedFiles() {

    }
}
