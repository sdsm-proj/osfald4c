package pl.org.opi.sdsm.app.simplerepo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.org.opi.sdsm.app.simplerepo.model.config.ConfigModel;
import pl.org.opi.sdsm.app.simplerepo.model.queries.QueriesModel;
import pl.org.opi.sdsm.app.simplerepo.model.tables.TablesModel;
import pl.org.opi.sdsm.frmwk.mechanics.genmodel.BaseGenModel;

@Data
@EqualsAndHashCode(callSuper=false)
public class SimpleRepoGenModel extends BaseGenModel {
    private final ConfigModel configModel = new ConfigModel();

    @JsonIgnore
    private final TablesModel tablesModel = new TablesModel();

    @JsonIgnore
    private final QueriesModel queriesModel = new QueriesModel();
}
