package pl.org.opi.sdsm.app.simplerepo.model.queries;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import pl.org.opi.sdsm.app.simplerepo.model.queries.sub.QueryDetails;

@Data
public class QueriesModel {
    private final Map<String, QueryDetails> mapQueries = new HashMap<>();
}
