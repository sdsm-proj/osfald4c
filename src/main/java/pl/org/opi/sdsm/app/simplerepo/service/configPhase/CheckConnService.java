package pl.org.opi.sdsm.app.simplerepo.service.configPhase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.model.SimpleRepoGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;

@Slf4j
public class CheckConnService {
  
    public void exec() throws SQLException {
        SimpleRepoGenModel model = (SimpleRepoGenModel) SdsmCtx.getInstance().getCurrGen().getModel();
        model.getConfigModel();
        //DriverManager.getConnection("jdbc:postgresql://localhost/prq02?currentSchema=px","prq02_admin","abcd1234");
        //DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");          
        //Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/prq02?currentSchema=px","prq02_admin","abcd1234");
        Connection conn = DriverManager.getConnection(
                model.getConfigModel().getDatabaseUrl(),
                model.getConfigModel().getDatabaseUser(),
                model.getConfigModel().getDatabasePass()
        );
        if (conn != null) {
            try {
                conn.close();
            } catch(Exception ex) {
                log.error(ex.getMessage(), ex);
            }
        }
    }
    
}
