package pl.org.opi.sdsm.app.simplerepo.oper.configPhase;

import java.sql.Connection;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.service.other.GetConn;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class VerifyConnUop {

    public void exec() {
        try (Connection conn = new GetConn().exec()) {
            OsfaldMsgBox.info("Connection OK");
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }

}
