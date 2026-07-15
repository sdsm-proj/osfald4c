package pl.org.opi.sdsm.app.spasection.oper.generatePhase;

import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.stru.generatePhase.ui.GenerateViewPanel;
import pl.org.opi.util.showDiff.ShowDiff;
import pl.org.opi.sdsm.frmwk.util.fileSave.FileSave;

import java.io.IOException;

public class ShowArtifactOper {

    private final GenerateViewPanel viewPanel;

    public ShowArtifactOper(GenerateViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    public void exec() {
        ShowDiff.Mode mode = ShowDiff.Mode.AB;
        if (viewPanel.getRadioButton1().isSelected()) {
            mode = ShowDiff.Mode.AB;
        } else if (viewPanel.getRadioButton2().isSelected()) {
            mode = ShowDiff.Mode.BC;

        } else if (viewPanel.getRadioButton3().isSelected()) {
            mode = ShowDiff.Mode.AC;
        }

        String contentA = "";
        String contentB = "";
        String contentC = "";

        int selIndex = viewPanel.getTableArtifacts().getSelectionModel().getMinSelectionIndex();
        if (selIndex >= 0) {
            var artifact = _SpaSectionGenUtil.getModel().getOperCache().getArtifactDepot().getArtifacts().get(selIndex);
            if (artifact != null) {
                if (artifact.getSrcFile() != null) {
                    try {
                        contentA = FileUtils.readFileToString(artifact.getSrcFile(), FileSave.UTF_8);
                    } catch (IOException ex) {
                        // OK
                    }
                }
                contentB = artifact.getGenCode();
                contentC = artifact.getGenCodeAi();
            }
        }

        new ShowDiff(mode, true,
                viewPanel.getTextPane1(), viewPanel.getTextPane2(), viewPanel.getTextPane3(),
                contentA, contentB, contentC);

    }

}
