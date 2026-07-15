package pl.org.opi.sdsm.app.spasection.model.sub;

import lombok.Data;

@Data
public class EditSectionLevel {
    private String selectedSectionPartialPackageAuto = "";
    private String selectedSectionPartialPackage = "";
    private String selectedSectionPartialPackageUpper = "";

    private String domainFullClass = "";
    private String domainPackage = "";
    private String domainSimpleClass = "";
    private String domainSimpleClassLower = "";

    private String serviceOperationNameLower = "";
    private String serviceOperationNameUpper = "";
    private String rolePrefix = "";
}
