package pl.org.opi.sdsm.app.frontenddto.oper.extractPhase;

import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.app.frontenddto._FrontendDtoGenUtil;
import pl.org.opi.sdsm.app.frontenddto.stru.extractPhase.ui.FileRender;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

import java.io.File;
import java.util.Collections;

public class ReadSrcFileListOper {

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore() {
        loadAll();
        findDtos();
    }

    private void loadAll() {
        var vars = _FrontendDtoGenUtil.getModel().getVars();
        vars.getAllSrcTsFileList().clear();
        String s = _FrontendDtoGenUtil.getModel().getPrjRootPath();
        System.out.println(s);
        String src = _FrontendDtoGenUtil.getModel().getPrjRootPath() + "src/";
        var files = FileUtils.listFiles(new File(src), new String[]{"ts"}, true);
        for(File file: files) {
            vars.getAllSrcTsFileList().add(file);
        }
    }

    private void findDtos() {
        var vars = _FrontendDtoGenUtil.getModel().getVars();
        vars.getAllSrcDtoFrList().clear();
        for(var file: vars.getAllSrcTsFileList()) {
            if (file.getName().toLowerCase().trim().endsWith("dto.ts")) {
                vars.getAllSrcDtoFrList().add(new FileRender(file));
            }
        }
        Collections.sort(vars.getAllSrcDtoFrList());
    }

}
