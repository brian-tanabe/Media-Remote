package com.btanabe2.mr.ds.videofilesearcher;

import com.btanabe2.mr.ds.videofilesearcher.filters.VideoFilterI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Brian on 3/7/15.
 */
public class VideoFileExtensionFilterBuilder {
    private List<VideoFilterI> filters = new ArrayList<>();

    public VideoFileExtensionFilterBuilder addFilter(VideoFilterI... filtersToAdd) {
        Stream.of(filtersToAdd).forEach(f -> filters.add(f));
        return this;
    }

    public List<VideoFilterI> getFilterList() {
        return filters;
    }
}
