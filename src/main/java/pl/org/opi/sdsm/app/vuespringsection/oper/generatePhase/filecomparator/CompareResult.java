package pl.org.opi.sdsm.app.vuespringsection.oper.generatePhase.filecomparator;

import com.github.difflib.patch.DeltaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CompareResult {

    @Data
    static public class LineCompared {
        private String text;
        private DeltaType type = null;
        private String trimedText;
        private int level;

        private String fieldName;
        private String fieldFullPath;
        private String fieldValue;
        private int leadingSpacesCount;

        public LineCompared(String atext, DeltaType atype) {
            type = atype;
            if (StringUtils.isEmpty(atext) || atext.trim().length() == 0) {
                text = " ";
                trimedText = text;
                level = 0;
            } else {
                text = atext;
                trimedText = text.stripLeading();
                level = text.indexOf(trimedText) / 2 - 1;
            }
        }

        public String getTypeStr() {
            if (type != null) {
                return "" + type;
            }
            return null;
        }
    }

    @Data
    @AllArgsConstructor
    static public class CompareResultRow {
        private LineCompared lineLeft;
        private LineCompared lineRight;

        public String getCompareStatus() {
            if (lineLeft.getType() == null && lineRight.getType() == null) {
                return "";
            }

            String status = lineLeft.getTypeStr();
            if (status == null) {
                status = lineRight.getTypeStr();
            }
            return status;
        }

        public String getColorClassName() {
            String colorCss;

            switch (getCompareStatus()) {
                case "CHANGE":
                    colorCss = "compareStatusChange";
                    break;
                case "DELETE":
                    colorCss = "compareStatusDelete";
                    break;
                case "INSERT":
                    colorCss = "compareStatusInsert";
                    break;
                default:
                    colorCss = "compareStatusDefault";
            }

            // Konieczna korekta, algorytm czasem pokazuje identyczne wiersze na niebiesko
            if (lineLeft.getText().trim().equals(lineRight.getText().trim())) {
                colorCss = "compareStatusDefault";
            }

            return colorCss;
        }

        /**
         * @deprecated należy używać getColorClassName w atrybucie styleClass
         */
        @Deprecated(since="1.0.0-SNAPSHOT")
        public String getColor() {
            String color;

            switch (getCompareStatus()) {
                case "CHANGE":
                    color = "blue";
                    break;
                case "DELETE":
                    color = "red";
                    break;
                case "INSERT":
                    color = "green";
                    break;
                default:
                    color = "black";

            }

            // Konieczna korekta, algorytm czasem pokazuje identyczne wiersze na niebiesko
            if (lineLeft.getText().trim().equals(lineRight.getText().trim())) {
                color = "black";
            }

            return color;
        }
    }

    private List<CompareResultRow> rows = new ArrayList<>();

    public List<CompareResultRow> getRows() {
        return rows;
    }

    public void add(LineCompared lineLeft, LineCompared lineRight) {
        rows.add(new CompareResultRow(lineLeft, lineRight));
    }

}
