package pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.uop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.generator.qry.QryGenerator;
import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.generator.test.QryTestGenerator;
import pl.org.opi.sdsm.app.simplerepo.stru.generatePhase.ui.GenerateViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnGenerateQueryUop {
    
    public OnGenerateQueryUop(GenerateViewPanel panel) {
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
        new QryGenerator(queryName).exec();
        new QryTestGenerator(queryName).exec();
    }
    
}
