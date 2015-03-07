package com.btanabe2.mediaremote.test.unit;

import com.btanabe2.mediaremote.vlc.exceptions.VlcPathInvalidException;
import org.junit.Test;

import static com.btanabe2.mediaremote.test.fixtures.PathFixtures.TEST_VLC_EXECUTABLE_PATH;
import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcPathInvalidExceptionTests {

    @Test
    public void shouldBeAbleToFormatTheExceptionMessageProperly() {
        VlcPathInvalidException exception = new VlcPathInvalidException(TEST_VLC_EXECUTABLE_PATH);
        assertEquals("Did not format the exception message properly", String.format("Inputted path to VLC executable does not appear to be valid: <%s>", TEST_VLC_EXECUTABLE_PATH), exception.getMessage());
    }
}
