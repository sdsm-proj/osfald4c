package pl.org.opi.sdsm.app.frontenddto.model.var;

import lombok.Data;
import pl.org.opi.sdsm.app.frontenddto.stru.extractPhase.ui.FileRender;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Data
public class FrontendDtoVariablesModel {
   private List<File> allSrcTsFileList = new ArrayList<>();
   private List<FileRender> allSrcDtoFrList = new ArrayList<>();
   private SelectedDtoModel selectedDto = null;
}
