package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.model;

import lombok.Data;

@Data
public class Scenario02Config {
    private String pakietSekcji = "panOsfald";

    private boolean inputOutputWithPrefix = false;
    private String pakietInputOutputDto = "pl.org.opi.nawa.raport.formularz.v1.controller.dto";

    private String pakietController = "pl.org.opi.nawa.raport.formularz.v1.controller";

    private String rw = "rw";
    private String mutationPrefixDlaDokumentu = "RaportyV1";
    private String mutationPrefixOperacja = "Edytuj";

}
