package pl.org.opi.sdsm.app.emptygen.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.org.opi.sdsm.frmwk.mechanics.genmodel.BaseGenModel;

@Data
@EqualsAndHashCode(callSuper=false)
public class EmptyGenModel extends BaseGenModel {
    private String emptyName;
}
