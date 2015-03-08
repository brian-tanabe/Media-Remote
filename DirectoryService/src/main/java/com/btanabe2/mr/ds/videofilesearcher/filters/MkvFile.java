package com.btanabe2.mr.ds.videofilesearcher.filters;

/**
 * Created by Brian on 3/7/15.
 */
public class MkvFile implements VideoFilterI {

    @Override
    public String getExtension() {
        return "mkv";
    }
}
