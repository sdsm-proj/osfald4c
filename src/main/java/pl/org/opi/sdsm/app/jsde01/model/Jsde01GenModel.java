package pl.org.opi.sdsm.app.jsde01.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.org.opi.sdsm.app.jsde01.model.config.ConfigModel;
import pl.org.opi.sdsm.app.jsde01.model.extract.ExtractModel;
import pl.org.opi.sdsm.frmwk.mechanics.genmodel.BaseGenModel;

@Data
@EqualsAndHashCode(callSuper=false)
public class Jsde01GenModel extends BaseGenModel {
    private ConfigModel configModel = new ConfigModel();
    private ExtractModel extractModel = new ExtractModel();
}
