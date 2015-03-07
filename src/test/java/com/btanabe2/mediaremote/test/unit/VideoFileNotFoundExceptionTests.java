package com.btanabe2.mediaremote.test.unit;

import com.btanabe2.mediaremote.vlc.exceptions.VideoFileNotFoundException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Brian on 3/6/15.
 */
public class VideoFileNotFoundExceptionTests {
    private static final String testMoviePath = "~/Downloads/Wet\\ Hot\\ American\\ Summer.mkv";

    @Test
    public void shouldBeAbleToFormatTheExceptionMessageProperly() {
        VideoFileNotFoundException exception = new VideoFileNotFoundException(testMoviePath);
        assertEquals(String.format("Path does not point to a file: <%s>", testMoviePath), exception.getMessage());
    }
}
