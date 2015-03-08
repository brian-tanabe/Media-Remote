package com.btanabe2.mr.vl.vlc.exceptions;

/**
 * Created by Brian on 3/6/15.
 */
public class VideoFileNotFoundException extends Exception {

    public VideoFileNotFoundException() {}

    public VideoFileNotFoundException(String badPath) {
        super(String.format("Path does not point to a file: <%s>", badPath));
    }
}
