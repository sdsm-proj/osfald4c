package pl.org.opi.sdsm.app.jsde01.oper.configPhase._tmp;


import com.fasterxml.jackson.databind.ObjectMapper;
import pl.org.opi.sdsm.app.jsde01.stru.configPhase.ui.ConfigViewPanel;

public class Test01Oper {

    private final ConfigViewPanel viewPanel;

    private final ObjectMapper om = new ObjectMapper();

    public Test01Oper(ConfigViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    public void exec() {
        try {
            TestConfig tc = new TestConfig("Adam", "Bochenek");
            String s = om.writerWithDefaultPrettyPrinter().writeValueAsString(tc);
            //viewPanel.getTextPane1().setText(s);
        } catch (Exception ex) {
            //viewPanel.getTextPane1().setText(ex.getMessage());
        }
    }


}
