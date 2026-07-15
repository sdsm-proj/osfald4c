package pl.org.opi.sdsm.app.spasection.oper.generatePhase;

import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.stru.generatePhase.ui.GenerateViewPanel;
import pl.org.opi.util.genartifactdepot.GenArtifact;
import pl.org.opi.sdsm.frmwk.util.fileSave.FileSave;

import java.io.IOException;

public class SaveArtifactOper {

    private final GenerateViewPanel viewPanel;

    private GenArtifact selArtifact;

    public SaveArtifactOper(GenerateViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    public void exec() {
        int selIndex = viewPanel.getTableArtifacts().getSelectionModel().getMinSelectionIndex();
        if (selIndex >= 0) {
            var artifact = _SpaSectionGenUtil.getModel().getOperCache().getArtifactDepot().getArtifacts().get(selIndex);
            if (artifact != null) {
                selArtifact = artifact;
                save();
            }
        }
    }

    private void save() {
        try {
            FileUtils.write(selArtifact.getSrcFile(), selArtifact.getGenCode(), FileSave.UTF_8);
            selArtifact.setAlreadyWritten(true);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
