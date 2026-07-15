package pl.org.opi.sdsm.app.spasection.stru.extractPhase.ui;

import lombok.Getter;

import java.lang.reflect.Field;

@Getter
public class FldDefListElem {

    private final Field fldDef;

    public FldDefListElem(Field fldDef) {
        this.fldDef = fldDef;
    }

    @Override
    public String toString() {
        return fldDef.getName();
    }
}
