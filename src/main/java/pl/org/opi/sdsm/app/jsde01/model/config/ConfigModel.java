package pl.org.opi.sdsm.app.jsde01.model.config;

import lombok.Data;

@Data
public class ConfigModel {

    //******************************
    // Project
    //******************************

    private String coreSql = "C:\\prjdron\\jsde\\ln-profiles-api\\web-app\\src\\main\\resources\\db\\changelog\\";
    private String coreSrcDomainFolder = "C:\\prjdron\\jsde\\ln-profiles-api\\web-app\\src\\main\\java\\pl\\org\\opi\\ln\\jsde\\";
    private String coreDstDomainFolder = "C:\\prjdron\\jsde\\ln-profiles-api\\web-app\\src\\main\\java\\pl\\org\\opi\\ln\\exdo\\";

    //******************************
    // Convention
    //******************************

    private String convInfra = "infrastructure";
    private String convApp = "application";
    private String convAppDomainDto = "application.domain.dto";

    //******************************
    // Domain
    //******************************

    private String srcPackage = "pl.org.opi.ln.jsde";
    private String dstPackage = "pl.org.opi.ln.exdo";

    private String fileInfra = "infrastructure\\";
    private String fileApp = "application\\";
    private String fileAppDomainDto = "application\\domain\\dto\\";

    private String patternTableName = "jsde_domain";
    private String patternTableSqlFullFile = coreSql + "1.29.x.sql";
    //----
    private String genTableName = "jsde_exdo";
    private String genTableSqlFullFile = coreSql + "exdo.sql";

    //******************************
    // Artifacts
    //******************************

    //---------------------------
    private String patternEntityClass = "DomainEntity";
    private String patternEntityPackage =  srcPackage + "." + convInfra;
    private String patternEntityFullFile = coreSrcDomainFolder + fileInfra + patternEntityClass + ".java";
    //----
    private String genEntityClass = "ExdoEntity";
    private String genEntityPackage =  dstPackage + "." + convInfra;
    private String genEntityFullFile = coreDstDomainFolder + fileInfra + genEntityClass + ".java";
    //---------------------------
    private String patternAppEntityIdClass = "DomainId";
    private String patternAppEntityIdFullFile = coreSrcDomainFolder + fileApp + patternAppEntityIdClass + ".java";
    //----
    private String genAppEntityIdClass = "ExdoId";
    private String genAppEntityIdPackage =  dstPackage + "." + convApp;
    private String genAppEntityIdFullFile = coreDstDomainFolder + fileApp + genAppEntityIdClass + ".java";
    //---------------------------
    private String patternAppDtoDtoClass = "DomainDto";
    private String patternAppDtoDtoPackage = srcPackage + "." + convAppDomainDto;
    private String patternAppDtoDtoFullFile = coreSrcDomainFolder + fileAppDomainDto + patternAppDtoDtoClass + ".java";
    //----
    private String genAppDtoDtoClass = "ExdoDto";
    private String genAppDtoDtoPackage = dstPackage + "." + convAppDomainDto;
    private String genAppDtoDtoFullFile = coreDstDomainFolder + fileAppDomainDto + genAppDtoDtoClass + ".java";
    //---------------------------
    private String patternInfraAddVoClass = "DomainAddVo";
    private String patternInfraAddVoPackage = srcPackage + "." + convInfra;
    private String patternInfraAddVoFullFile = coreSrcDomainFolder + fileInfra + patternInfraAddVoClass + ".java";
    //----
    private String genInfraAddVoClass = "ExdoAddVo";
    private String genInfraAddVoPackage = dstPackage + "." + convInfra;
    private String genInfraAddVoFullFile = coreDstDomainFolder + fileInfra + genInfraAddVoClass + ".java";
    //---------------------------
    private String patternInfraRepoClass = "AdminRepository";
    private String patternInfraRepoPackage = srcPackage + "." + convInfra;
    private String patternIInfraRepoFullFile = coreSrcDomainFolder + fileInfra + patternInfraRepoClass + ".java";
    //----
    private String genInfraRepoClass = "ExdoRepository";
    private String genInfraRepoPackage = dstPackage + "." + convInfra;
    private String genInfraRepoFullFile = coreDstDomainFolder + fileInfra + genInfraRepoClass + ".java";
    //---------------------------

}
