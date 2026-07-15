package pl.org.opi.sdsm.app.spasection.stru.extractPhase.ui;

import lombok.Getter;

@Getter
public class ClazzListElem {

    private final Class<?> clazz;

    public ClazzListElem(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return clazz.getSimpleName() + "  (" + clazz.getCanonicalName() + ")";
    }

}
