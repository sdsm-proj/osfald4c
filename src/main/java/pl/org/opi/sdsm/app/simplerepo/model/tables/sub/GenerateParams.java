package pl.org.opi.sdsm.app.simplerepo.model.tables.sub;

import lombok.Data;

@Data
public class GenerateParams {
    private String repositoryRelativePath;
    private String repositoryClassName;
    private String entityRelativePath;
    private String entityClassName;
    private String testRelativePath;
    private String testClassName;
}
