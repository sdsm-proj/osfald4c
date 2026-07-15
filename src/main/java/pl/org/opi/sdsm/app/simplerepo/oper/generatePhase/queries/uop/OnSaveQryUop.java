package pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.uop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.simplerepo.stru.generatePhase.ui.GenerateViewPanel;
import pl.org.opi.sdsm.app.simplerepo.stru.generatePhase.ui.GenerateViewPanelTransfer;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnSaveQryUop {
    
    public OnSaveQryUop(GenerateViewPanel panel) {
        this.panel = panel;
    }
    
    private final GenerateViewPanel panel;
    
    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
            log.error(ex.getMessage(), ex);
        }
    }

    private void execCore() {
        String queryName = panel.getListChosenQueries().getSelectedValue();
        if (StringUtils.isBlank(queryName)) {
            throw new OsfaldRuntimeException("Choose query first.");
        }
        new GenerateViewPanelTransfer(panel).ui2Model();
        SdsmCtx.getInstance().getCurrGen().save();
    }
    
}
