package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.util.genartifactdepot.GenArtifact;
import pl.org.opi.util.genartifactdepot.GenArtifactDepot;

@Slf4j
public class CountLinesOfCodeOper {

    public void exec() {
        int locSumJava = 0;
        int locSumGraphQl = 0;

        var adepot = getMdxArtifactDepot();
        for(var af: adepot.getArtifacts()) {
            countLines(af);
        }

        for(var af: adepot.getArtifacts()) {
            if (af.getLanguage().equals(GenArtifact.EnumLanguage.JAVA)) {
                locSumJava += af.getGenCodeLoc();
            } else if (af.getLanguage().equals(GenArtifact.EnumLanguage.GRAPH_QL)) {
                locSumGraphQl += af.getGenCodeLoc();
            }
        }

        log.info("Sum LOC Java: " + locSumJava);
        log.info("Sum LOC GraphQl: " + locSumGraphQl);
    }

    protected GenArtifactDepot getMdxArtifactDepot() {
        return _SpaSectionGenUtil.getModel().getOperCache().getArtifactDepot();
    }

    private int countLines(GenArtifact af) {
        var genCode = af.getGenCode();
        String[] codeLines = genCode.split("\\r?\\n|\\r");
        int loc = 0;
        for (String s: codeLines) {
            //if (StringUtils.isNotBlank(s)) {
                loc++;
            //}
        }
        af.setGenCodeLoc(loc);
        return loc;
    }

}
