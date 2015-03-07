package com.btanabe2.mediaremote.test.unit;

import com.btanabe2.mediaremote.vlc.exceptions.VlcPathInvalidException;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcPathInvalidExceptionTests {
    private static final String testVlcExecutablePath = "/Applications/VLC.app/Contents/MacOS/VLC";

    @Test
    public void shouldBeAbleToFormatTheExceptionMessageProperly() {
        VlcPathInvalidException exception = new VlcPathInvalidException(testVlcExecutablePath);
        assertEquals("Did not format the exception message properly", String.format("Inputted path to VLC executable does not appear to be valid: <%s>", testVlcExecutablePath), exception.getMessage());
    }
}
