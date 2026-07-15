package pl.org.opi.util.classdepot;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.TypeDeclaration;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;

@AllArgsConstructor
@Getter
public class ClassCuComplex {
    private Class<?> clazz;
    private File targetFullFileName;
    private String javaFullFileName;
    private CompilationUnit cu;
    private TypeDeclaration<?> cuType;
}
