package pl.org.opi.sdsm.app.frontenddto.model.var;

import lombok.Data;

import java.io.File;

@Data
public class SelectedDtoModel {
    private EnumDtoVariant dtoVariant;
    private File file;
    private String sourceText;
    private String compressedText;

    public SelectedDtoModel() {
        clear();
    }

    public void clear() {
        dtoVariant = EnumDtoVariant.NONE;
        file = null;
        sourceText = "";
        compressedText = "";
    }
}
