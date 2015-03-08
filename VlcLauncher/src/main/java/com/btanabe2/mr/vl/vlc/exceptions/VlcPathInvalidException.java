package com.btanabe2.mr.vl.vlc.exceptions;

/**
 * Created by Brian on 3/6/15.
 */
public class VlcPathInvalidException extends Exception {

    public VlcPathInvalidException() {}

    public VlcPathInvalidException(String badPath) {
        super(String.format("Inputted path to VLC executable does not appear to be valid: <%s>", badPath));
    }
}
