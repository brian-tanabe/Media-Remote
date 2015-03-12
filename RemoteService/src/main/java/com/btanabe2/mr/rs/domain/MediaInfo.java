package com.btanabe2.mr.rs.domain;

/**
 * Created by Brian on 3/11/15.
 */
public class MediaInfo {
    private final long id;
    private final String filePath;

    public MediaInfo(long id, String filePath) {
        this.id = id;
        this.filePath = filePath;
    }

    public long getId() {
        return id;
    }

    public String getFilePath() {
        return filePath;
    }
}
