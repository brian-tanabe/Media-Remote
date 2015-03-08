package com.btanabe2.mr.ds.videofilesearcher.filters;

/**
 * Created by Brian on 3/7/15.
 */
public class Mp4File implements VideoFilterI {

    @Override
    public String getExtension() {
        return "mp4";
    }
}
