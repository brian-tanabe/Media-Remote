package com.btanabe2.mr.ds.test.unit;

import com.btanabe2.mr.ds.videofilesearcher.DirectoryMonitor;
import com.btanabe2.mr.ds.videofilesearcher.VideoFileExtensionFilter;
import com.btanabe2.mr.ds.videofilesearcher.VideoFileExtensionFilterBuilder;
import com.btanabe2.mr.ds.videofilesearcher.filters.AviFile;
import com.btanabe2.mr.ds.videofilesearcher.filters.MkvFile;
import com.btanabe2.mr.ds.videofilesearcher.filters.Mp4File;
import com.btanabe2.mr.ds.videofilesearcher.filters.RarFile;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.btanabe2.mr.ds.test.fixtures.TestVideoCreationFixtures.TEST_VIDEO_CREATION_DIRECTORY;
import static com.btanabe2.mr.ds.test.fixtures.TestVideoCreationFixtures.TEST_VIDEO_CREATION_FILE_PATH;
import static com.btanabe2.mr.ds.test.fixtures.TestVideoFixture.*;
import static com.btanabe2.mr.ds.test.helpers.TestFileCreator.createTestFile;
import static junit.framework.TestCase.assertEquals;
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

    @BeforeClass
    public static void deleteAllTestFilesInTheFileCreationDirectory() {
        FileUtils.deleteQuietly(TEST_VIDEO_CREATION_FILE_PATH);
    }

    @Before
    public void createNewTestEnvironment() {
        videoFileList = new ArrayList<>();
        monitor = new DirectoryMonitor();
    }

    @Test
    public void shouldBeAbleToFindOneFileInOneDirectory() {
        monitor.monitorDirectories(videoFileList, filter, TEST_VIDEO_SINGLE_FILE_PARENT_DIRECTORY);
        assertThat(videoFileList, hasItems(TEST_VIDEO_SINGLE_FILE));
    }

    @Test
    public void shouldBeAbleToFindMultipleFilesInOneDirectory() {
        monitor.monitorDirectories(videoFileList, filter, TEST_VIDEO_MULTIPLE_FILES_PARENT_DIRECTORY);
        assertThat(videoFileList, hasItems(TEST_VIDEO_MULTIPLE_FILES_FIRST_FILE, TEST_VIDEO_MULTIPLE_FILES_SECOND_FILE));
    }

    @Test
    public void shouldBeAbleToFindMultipleFilesInMultipleSubdirectory() {
        monitor.monitorDirectories(videoFileList, filter, TEST_VIDEO_PARENT_DIRECTORY);
        assertThat(videoFileList, hasItems(TEST_VIDEO_SINGLE_FILE, TEST_VIDEO_MULTIPLE_FILES_FIRST_FILE, TEST_VIDEO_MULTIPLE_FILES_SECOND_FILE, TEST_VIDEO_MIXED_TYPE_FILE, TEST_VIDEO_SPLIT_COMPRESSED_TYPE_FILE));
    }

    @Test
    public void shouldBeAbleToFindVideoFilesCompressedAndSplitAsRarFiles() {
        monitor.monitorDirectories(videoFileList, filter, TEST_VIDEO_SPLIT_COMPRESSED_TYPE_PARENT_DIRECTORY);
        assertThat(videoFileList, hasItems(TEST_VIDEO_SPLIT_COMPRESSED_TYPE_FILE));
    }

    @Test
    public void shouldBeAbleToExcludeNonVideoFiles() {
        monitor.monitorDirectories(videoFileList, filter, TEST_VIDEO_MIXED_FILE_TYPE_PARENT_DIRECTORY);
        assertThat(videoFileList, hasItems(TEST_VIDEO_MIXED_TYPE_FILE));
    }

    @Test
    public void shouldBeAbleToFindNewlyCreatedFiles() {
        try {
            monitor.monitorDirectories(videoFileList, filter, TEST_VIDEO_CREATION_DIRECTORY);
            assertEquals("The test video was created too soon!", 0, videoFileList.size());
            this.wait(100);
            createTestFile(TEST_VIDEO_CREATION_FILE_PATH);
            assertThat(videoFileList, hasItems(TEST_VIDEO_CREATION_FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to wait() or create test file");
        }
    }
}
