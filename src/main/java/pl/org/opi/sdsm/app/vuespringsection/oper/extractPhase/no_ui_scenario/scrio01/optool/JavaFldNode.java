package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.optool;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class JavaFldNode {
    private final String fldName;
    private final String fldTypeName;
    private final String typePkgName;
    private final boolean ourKlazz;
    private final boolean list;

    private final List<JavaFldNode> subs = new ArrayList<>();

    public void show() {
        System.out.println("-----------------------------------------------------------------------------------------");
        showRecur(this, 0);
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    private void showRecur(JavaFldNode node, int margin) {
        System.out.println(StringUtils.repeat(" ", margin)
                + node.getFldName() + " : "
                + (node.list ? " List<" : "")
                + node.getFldTypeName()
                + (node.list ? ">" : "")
                + (node.ourKlazz ? " *" : " ")
                + (StringUtils.isBlank(node.getTypePkgName()) ? "" : (" [" + node.getTypePkgName() + "]"))
        );
        for(var nn: node.getSubs()) {
            showRecur(nn, margin + 4);
        }
    }

}
