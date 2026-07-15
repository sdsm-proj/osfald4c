package pl.org.opi.util.classdepot.old;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;

@AllArgsConstructor
@Getter
public class SourceCompiledFolderPair {
    private File sourceFolder;
    private File compiledFolder;
}
