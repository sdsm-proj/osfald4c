package pl.org.opi.util.classdepot;

import java.util.List;

public interface ClassDepot {
    void loadAll() throws Exception;
    List<ClassCuComplex> wyszukajDokumenty();

    boolean existsClass(String canonicalName);

}
