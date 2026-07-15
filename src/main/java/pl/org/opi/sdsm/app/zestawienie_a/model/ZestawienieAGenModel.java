package pl.org.opi.sdsm.app.zestawienie_a.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.org.opi.sdsm.app.zestawienie_a.model.config.ZaConfigModel;
import pl.org.opi.sdsm.app.zestawienie_a.model.edit.ZaEditModel;
import pl.org.opi.sdsm.app.zestawienie_a.model.extract.ZaExtractModel;
import pl.org.opi.sdsm.app.zestawienie_a.model.generate.ZaGenerateModel;
import pl.org.opi.sdsm.frmwk.mechanics.genmodel.BaseGenModel;

@Data
@EqualsAndHashCode(callSuper=false)
public class ZestawienieAGenModel extends BaseGenModel {
    private ZaConfigModel configModel = new ZaConfigModel();
    private ZaExtractModel extractModel = new ZaExtractModel();
    private ZaEditModel editModel = new ZaEditModel();
    @JsonIgnore
    private ZaGenerateModel generateModel = new ZaGenerateModel();
}
