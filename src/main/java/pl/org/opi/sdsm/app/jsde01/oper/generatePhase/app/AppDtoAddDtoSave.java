package pl.org.opi.sdsm.app.jsde01.oper.generatePhase.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;

@RequiredArgsConstructor
public class AppDtoAddDtoSave {

    private final StepPanel stepPanel;

    private final ObjectMapper om = new ObjectMapper();

    public void exec() {
    }

}
