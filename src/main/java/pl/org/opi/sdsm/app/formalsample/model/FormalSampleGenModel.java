package pl.org.opi.sdsm.app.formalsample.model;

import lombok.Data;
import pl.org.opi.sdsm.frmwk.mechanics.genmodel.BaseGenModel;

@Data
public class FormalSampleGenModel extends BaseGenModel {
    private ConfigModel configModel = new ConfigModel();
    private RawModel rawModel = new RawModel();
    private FinalModel finalModel = new FinalModel();
}
