package pl.org.opi.sdsm.app.spasection.oper.other;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.util.classdepot.ClassDepot;
import pl.org.opi.util.classdepot.ClassDepot2Impl;
import pl.org.opi.util.classdepot.JarDef;
import pl.org.opi.util.classdepot.SourceTargetDef;

import java.util.ArrayList;
import java.util.List;

public class LoadClassesOper {

    public void exec() throws Exception {
        var config = _SpaSectionGenUtil.getModel().getConfigPrjLevel();

        SourceTargetDef sourceTargetDef = new SourceTargetDef(
                _SpaSectionGenUtil.getModel().getPrjRootPath(),
                config.getSourceSubPath(),
                config.getTargetSubPath(),
                new SplitLinesCommas().exec(config.getLookForClassesSubPath())
        );

        List<JarDef> jarList = new ArrayList<>();
        for(String jar: new SplitLinesCommas().exec(config.getJars())) {
            jarList.add(new JarDef(jar));
        }

        ClassDepot cdep = new ClassDepot2Impl(sourceTargetDef, jarList.toArray(JarDef[]::new));
        cdep.loadAll();
        _SpaSectionGenUtil.getModel().getOperCache().setClassDepot(cdep);
    }

}
