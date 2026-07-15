package pl.org.opi.sdsm.app.jsde01.oper.configPhase._tmp;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.org.opi.sdsm.app.jsde01.stru.configPhase.ui.ConfigViewPanel;

public class Test02Oper {

    private final ConfigViewPanel viewPanel;

    private final ObjectMapper om = new ObjectMapper();

    public Test02Oper(ConfigViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    public void exec() {
        try {
//            String s1 = viewPanel.getTextPane1().getText();
//            TestConfig tc = om.readValue(s1, TestConfig.class);
//            String s2 = om.writerWithDefaultPrettyPrinter().writeValueAsString(tc);
//            viewPanel.getTextPane2().setText(s2);
        } catch(Exception ex) {
//            viewPanel.getTextPane2().setText(ex.getMessage());
        }
    }

}
