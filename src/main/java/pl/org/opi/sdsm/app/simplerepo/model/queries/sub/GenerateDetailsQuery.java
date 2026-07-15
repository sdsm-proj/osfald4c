package pl.org.opi.sdsm.app.simplerepo.model.queries.sub;

import lombok.Data;

@Data
public class GenerateDetailsQuery {
    private String queryPackage;
    private String queryTestPackage;
}
