package pl.org.opi.util.genartifactdepot;

import lombok.Getter;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

@Getter
public class GenArtifactDepot extends DefaultTableModel {

    private final List<GenArtifact> artifacts = new ArrayList<>();

    public void add(GenArtifact ga) {
        artifacts.add(ga);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public int getRowCount() {
        if (artifacts == null) return 0;
        return artifacts.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (artifacts == null) return null;
        return switch (columnIndex) {
            case 0 -> "Front/Back";
            case 1 -> "Lang";
            case 2 -> "Class/type";
            case 3 -> "Full/part";
            case 4 -> "File";
            case 5 -> "LOC";
            case 6 -> "Written";
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (artifacts == null) return null;
        return switch (columnIndex) {
            case 0 -> artifacts.get(rowIndex).getFrontBack().toString();
            case 1 -> artifacts.get(rowIndex).getLanguage().toString();
            case 2 -> artifacts.get(rowIndex).getArtifactDisplayName();
            case 3 -> artifacts.get(rowIndex).getFullPart().toString();
            case 4 -> artifacts.get(rowIndex).getSrcFullPath();
            case 5 -> artifacts.get(rowIndex).getGenCodeLoc();
            case 6 -> (artifacts.get(rowIndex).isAlreadyWritten() ? "X" : "");
            default -> null;
        };
    }

}
