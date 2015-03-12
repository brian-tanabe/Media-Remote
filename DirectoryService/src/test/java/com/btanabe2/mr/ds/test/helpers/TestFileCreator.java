package com.btanabe2.mr.ds.test.helpers;

import java.io.File;
import java.io.IOException;

/**
 * Created by Brian on 3/7/15.
 */
public class TestFileCreator {

    public static void createTestFile(File newFile) throws IOException {
        newFile.createNewFile();
    }
}
