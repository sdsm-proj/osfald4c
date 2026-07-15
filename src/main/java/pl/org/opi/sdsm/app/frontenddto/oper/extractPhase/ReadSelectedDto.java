package pl.org.opi.sdsm.app.frontenddto.oper.extractPhase;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.frontenddto._FrontendDtoGenUtil;
import pl.org.opi.sdsm.app.frontenddto.model.var.EnumDtoVariant;
import pl.org.opi.sdsm.app.frontenddto.model.var.SelectedDtoModel;
import pl.org.opi.sdsm.app.frontenddto.stru.extractPhase.ui.FileRender;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadSelectedDto {

    public void exec(FileRender fr) {
        try {
            execCore(fr);
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore(FileRender fr) throws IOException {
        SelectedDtoModel selDto = new SelectedDtoModel();
        selDto.setFile(fr.getFile());
        selDto.setSourceText(FileUtils.readFileToString(fr.getFile(), UTF_8));

        String compressSrc = StringUtils.deleteWhitespace(selDto.getSourceText());
        selDto.setCompressedText(compressSrc);
        if (compressSrc.contains("exporttype") && compressSrc.contains("exportconst")) {
            selDto.setDtoVariant(EnumDtoVariant.TYPE_AND_CONST);
        } else if (compressSrc.contains("exporttype")) {
            selDto.setDtoVariant(EnumDtoVariant.ONLY_TYPE);
        } else if (compressSrc.contains("exportinterface")) {
            selDto.setDtoVariant(EnumDtoVariant.INTERFACE);
        } else {
            selDto.setDtoVariant(EnumDtoVariant.NONE);
        }

        _FrontendDtoGenUtil.getModel().getVars().setSelectedDto(selDto);
    }

}
