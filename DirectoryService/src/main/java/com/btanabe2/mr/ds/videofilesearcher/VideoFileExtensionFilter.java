package com.btanabe2.mr.ds.videofilesearcher;

import com.btanabe2.mr.ds.videofilesearcher.filters.VideoFilterI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Brian on 3/7/15.
 */
public class VideoFileExtensionFilter {
    private List<VideoFilterI> filters;

    public VideoFileExtensionFilter(VideoFileExtensionFilterBuilder videoFileExtensionFilterBuilder){
        filters = videoFileExtensionFilterBuilder.getFilterList();
    }

    public Collection<String> getFilterExtensionStringArray() {
        Collection<String> extensionList = new ArrayList<>(filters.size());
        filters.forEach(f -> extensionList.add(f.getExtension()));
        return extensionList;
    }
}
