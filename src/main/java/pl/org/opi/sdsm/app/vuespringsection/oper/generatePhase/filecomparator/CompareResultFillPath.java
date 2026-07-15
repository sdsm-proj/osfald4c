package pl.org.opi.sdsm.app.vuespringsection.oper.generatePhase.filecomparator;

import org.apache.commons.lang3.StringUtils;

import java.util.SortedMap;
import java.util.TreeMap;

public class CompareResultFillPath {

    public CompareResultFillPath(CompareResult compareResult) {
        this.compareResult = compareResult;
    }

    private final CompareResult compareResult;

    public void exec() {
        reset();
        rowLeft = true;
        processRows();
        reset();
        rowLeft = false;
        processRows();
    }

    private boolean rowLeft = false;

    private final SortedMap<Integer, String> lastNameForLevel = new TreeMap<>();

    private void reset() {
        lastNameForLevel.clear();
    }

    private CompareResult.LineCompared getLine(CompareResult.CompareResultRow row) {
        if (rowLeft) {
            return row.getLineLeft();
        } else {
            return row.getLineRight();
        }
    }

    private int getLeadingSpacesCount(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                cnt++;
            } else {
                return cnt;
            }
        }
        return cnt;
    }

    private int getFirstColonPos(String s) {
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ':') {
                return i;
            }
        }
        return -1;
    }

    private String getFieldName(String s) {
        int colonPos = getFirstColonPos(s);
        if (colonPos >= 0) {
            return s.substring(0, colonPos).trim();
        } else {
            return s.trim();
        }
    }

    private String getFieldValue(String s) {
        int colonPos = getFirstColonPos(s);
        if (colonPos >= 0) {
            return s.substring(colonPos + 1).trim();
        }
        return "";
    }

    private String findPathIncl(int leadingSpacesCnt, String fieldName) {
        String path = "";
        var subMap = lastNameForLevel.subMap(0, leadingSpacesCnt);
        for(int key: subMap.keySet()) {
            if (StringUtils.isNotBlank(subMap.get(key))) {
                path += "/" + subMap.get(key);
            }
        }
        path += "/" + fieldName;
        return path;
    }

    private void processRows() {
        for(CompareResult.CompareResultRow row: compareResult.getRows()) {
            CompareResult.LineCompared line = getLine(row);
            if (StringUtils.isBlank(line.getTrimedText())) {
                continue;
            }

            int leadingSpacesCnt = getLeadingSpacesCount(line.getText());
            String fname = getFieldName(line.getText());
            String fvalue = getFieldValue(line.getText());
            String fpath = "";

            if (StringUtils.isNotBlank(fname)) {
                setLastNameForLevel(leadingSpacesCnt, fname);
                fpath = findPathIncl(leadingSpacesCnt, fname);
            }

            line.setFieldName(fname);
            line.setFieldValue(fvalue);
            line.setFieldFullPath(fpath);
            line.setLeadingSpacesCount(leadingSpacesCnt);
        }
    }

    private void setLastNameForLevel(int leadingSpacesCnt, String fname) {
        for(Integer k : lastNameForLevel.keySet()) {
            if (k > leadingSpacesCnt) {
                lastNameForLevel.put(k, null);
            }
        }
        lastNameForLevel.put(leadingSpacesCnt, fname);
    }

}
