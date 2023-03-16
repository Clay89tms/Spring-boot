package org.tms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateFiles {
    public static void createFiles(Path path, Path pathValid, Path pathFail) throws IOException {
        if (!Files.exists(path)) {
            Path fileValid = Files.createFile(path);
        }
        if (!Files.exists(pathValid)) {
            Path fileValid = Files.createFile(pathValid);
        }
        if (!Files.exists(pathFail)) {
            Path fileFail = Files.createFile(pathFail);
        }
    }
}
