package pl.org.opi.sdsm.app.simplerepo.model.tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.TableDetails;

@Data
public class TablesModel {
    private final Map<String, TableDetails> mapTables = new HashMap<>();
}
