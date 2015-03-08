package test.unit;

import org.junit.Test;
import vlc.exceptions.VlcPathInvalidException;

import static junit.framework.TestCase.assertEquals;
import static test.fixtures.PathFixtures.TEST_VLC_EXECUTABLE_PATH;

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
