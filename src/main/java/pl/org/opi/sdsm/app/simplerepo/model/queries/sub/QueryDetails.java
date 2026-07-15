package pl.org.opi.sdsm.app.simplerepo.model.queries.sub;

import java.util.LinkedHashMap;
import lombok.Data;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.FldDetails;

@Data
public class QueryDetails {
    private String queryName;
    private String sql;
    private final GenerateParamsQuery generateParamsQuery = new GenerateParamsQuery();
    private final GenerateDetailsQuery generateDetailsQuery = new GenerateDetailsQuery();
    private final LinkedHashMap<String, FldDetails> mapFlds = new LinkedHashMap<>();
}
