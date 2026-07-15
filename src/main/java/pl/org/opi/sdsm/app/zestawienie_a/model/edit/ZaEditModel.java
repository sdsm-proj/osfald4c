package pl.org.opi.sdsm.app.zestawienie_a.model.edit;

import lombok.Data;

@Data
public class ZaEditModel {
    private String angularComponentPath;
    private String angularComponentShortFileName;

    private String angularComponentTsFullFileName;
    private String angularComponentHtmlFullFileName;
    private String angularComponentCssFullFileName;

    private String componentClassName;
    private String selector;
}
