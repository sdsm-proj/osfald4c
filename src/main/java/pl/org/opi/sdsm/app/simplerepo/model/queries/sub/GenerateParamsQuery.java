package pl.org.opi.sdsm.app.simplerepo.model.queries.sub;

import lombok.Data;

@Data
public class GenerateParamsQuery {
    private String queryClassName;
    private String queryEntityClassName;
    private String queryRelativePath;
    private String testRelativePath;
    private String testClassName;
}
