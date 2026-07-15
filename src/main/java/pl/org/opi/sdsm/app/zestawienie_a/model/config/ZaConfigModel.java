package pl.org.opi.sdsm.app.zestawienie_a.model.config;

import lombok.Data;

@Data
public class ZaConfigModel {
    private String prjFrontFullPath = "C:\\prjdron\\skel-alpha\\frontend-16";
    private String prjContractFullPath = "C:\\prjdron\\skel-alpha\\contract";
    private String prjBackendFullPath = "C:\\prjdron\\skel-alpha\\backend";
    private String prjBackendGenFullPath = "C:\\prjdron\\skel-alpha\\backend\\target\\generated-sources\\openapi\\src\\gen\\java\\org\\openapitools";
}
