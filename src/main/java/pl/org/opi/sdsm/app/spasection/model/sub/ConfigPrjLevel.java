package pl.org.opi.sdsm.app.spasection.model.sub;

import lombok.Data;

@Data
public class ConfigPrjLevel {
    private String sourceSubPath;
    private String targetSubPath;
    private String lookForClassesSubPath;
    private String jars;
}
