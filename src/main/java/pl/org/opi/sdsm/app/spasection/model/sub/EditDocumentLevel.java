package pl.org.opi.sdsm.app.spasection.model.sub;

import lombok.Data;

@Data
public class EditDocumentLevel {
    private String javaDocumentPrefix = "RaportyV1";
    private String javaDtoPackage = "pl.org.opi.nawa.raport.formularz.v1.controller.dto";
    private String javaMapperPackage = "pl.org.opi.nawa.raport.formularz.v1.controller.mapper";
    private String javaServicePackage = "pl.org.opi.nawa.raport.formularz.v1.service.sekcje";
    private String javaControllerPackage = "pl.org.opi.nawa.raport.formularz.v1.controller.sekcje";
}
