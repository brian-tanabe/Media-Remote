package com.btanabe2.mr.ds.test.unit;

import com.btanabe2.mr.ds.videofilesearcher.DirectoryMonitor;
import com.btanabe2.mr.ds.videofilesearcher.VideoFileExtensionFilter;
import com.btanabe2.mr.ds.videofilesearcher.VideoFileExtensionFilterBuilder;
import com.btanabe2.mr.ds.videofilesearcher.filters.AviFile;
import com.btanabe2.mr.ds.videofilesearcher.filters.MkvFile;
import com.btanabe2.mr.ds.videofilesearcher.filters.Mp4File;
import com.btanabe2.mr.ds.videofilesearcher.filters.RarFile;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by Brian on 3/7/15.
 */
public class DirectoryMonitorTests {
    private DirectoryMonitor monitor;
    private static VideoFileExtensionFilter filter;
    private List<File> videoFileList;

    @BeforeClass
    public static void buildExtensionFilter() {
        VideoFileExtensionFilterBuilder builder = new VideoFileExtensionFilterBuilder();
        builder.addFilter(new AviFile(), new RarFile(), new MkvFile(), new Mp4File());
        filter = new VideoFileExtensionFilter(builder);
    }

    @Before
    public void createNewTestEnvironment() {
        videoFileList = new ArrayList<>();
        monitor = new DirectoryMonitor();
    }

    @Test
    public void shouldBeAbleToFindOneFileInOneDirectory() {
        monitor.monitorDirectories(videoFileList, filter, new File("./DirectoryService/src/test/resources/test-video-directory/single-file/"));
        assertThat(videoFileList, hasItems(new File("./DirectoryService/src/test/resources/test-video-directory/single-file/Whiplash.2014.720p.WEB-DL.AAC2.0.H264-BHD.mkv")));
    }

    @Test
    public void shouldBeAbleToFindMultipleFilesInOneDirectory() {
        monitor.monitorDirectories(videoFileList, filter, new File("./DirectoryService/src/test/resources/test-video-directory/multiple-files/"));
        assertThat(videoFileList, hasItems(new File("./DirectoryService/src/test/resources/test-video-directory/multiple-files/What.We.Do.In.The.Shadows.2014.HDRip.x264-COX.mkv"), new File("./DirectoryService/src/test/resources/test-video-directory/multiple-files/Standby.2014.720p.WEB-DL.x264.AC3-iFT.mkv")));
    }

    @Test
    public void shouldBeAbleToFindMultipleFilesInMultipleSubdirectory() {
        fail("Not yet implemented");
    }

    @Test
    public void shouldBeAbleToFindVideoFilesCompressedAndSplitAsRarFiles() {
        monitor.monitorDirectories(videoFileList, filter, new File("./DirectoryService/src/test/resources/test-video-directory/split-compressed-files/"));
        assertThat(videoFileList, hasItems(new File("./DirectoryService/src/test/resources/test-video-directory/split-compressed-files/The.Americans.2013.S03E05.720p.HDTV.x264-KILLERS/the.americans.2013.s03e05.720p.hdtv.x264-killers.rar")));
    }

    @Test
    public void shouldBeAbleToExcludeNonVideoFiles() {
        fail("Not yet implemented");
    }

    @Test
    public void shouldBeAbleToFindNewlyCreatedFiles() {
        fail("Not yet implemented");
    }
}
