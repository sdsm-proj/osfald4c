package pl.org.opi.sdsm.app.vuespringsection.util.graphqlparse;

import graphql.parser.Parser;
import graphql.language.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GraphQlParse {

    public void exec() {
        try {
            execCore();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    private void execCore() throws FileNotFoundException {
        Parser parser = new Parser();
        Document doc = parser.parseDocument(new FileReader(new File("C:\\ncn\\osf-ncn-nawa-back\\src\\main\\resources\\graphql\\raport.graphqls")));

        int dbg1 = 1;
    }

}
