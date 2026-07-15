package pl.org.opi.sdsm.app.vuespringsection.oper.generatePhase.filecomparator;


import com.github.difflib.DiffUtils;
import com.github.difflib.patch.AbstractDelta;
import com.github.difflib.patch.Patch;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;

import java.util.ArrayList;
import java.util.List;

import static com.github.difflib.patch.DeltaType.*;

public class CompareText {

    private final List<CompareResult.LineCompared> linesLeft = new ArrayList<>();
    private final List<CompareResult.LineCompared> linesRight = new ArrayList<>();

    public CompareResult compare(List<String> srcLeft, List<String> srcRight) {
        CompareResult rslt = new CompareResult();

        linesLeft.clear();
        linesRight.clear();
        for (String s : srcLeft) {
            linesLeft.add(new CompareResult.LineCompared(s, null));
        }
        for (String s : srcRight) {
            linesRight.add(new CompareResult.LineCompared(s, null));
        }

        List<String> srcLeftTrim = new ArrayList<>();
        for (String s : srcLeft) {
            srcLeftTrim.add(s != null ? s.trim() : "");
        }
        List<String> srcRightTrim = new ArrayList<>();
        for (String s : srcRight) {
            srcRightTrim.add(s != null ? s.trim() : "");
        }

        Patch<String> patch = DiffUtils.diff(srcLeftTrim, srcRightTrim);

        for (AbstractDelta<String> d : patch.getDeltas()) {
            switch (d.getType()) {
                case DELETE -> applyPatchDelete(d);
                case INSERT -> applyPatchInsert(d);
                case CHANGE -> applyPatchChange(d);
            }
        }

        if (linesLeft.size() == linesRight.size()) {
            for (int i = 0; i < linesLeft.size(); i++) {
                rslt.add(linesLeft.get(i), linesRight.get(i));
            }
        } else {
            throw new OsfaldRuntimeException("CompareResult: L.size != R.size");
        }

        postProcess(rslt);

        return rslt;
    }

    private void applyPatchDelete(AbstractDelta<String> delta) {
        int pos = delta.getSource().getPosition();
        int count = delta.getSource().getLines().size();
        for (int i = 0; i < count; i++) {
            linesRight.add(pos, new CompareResult.LineCompared("", DELETE));
        }
    }

    private void applyPatchInsert(AbstractDelta<String> delta) {
        int pos = delta.getTarget().getPosition();
        int count = delta.getTarget().getLines().size();
        for (int i = 0; i < count; i++) {
            linesLeft.add(pos, new CompareResult.LineCompared("", INSERT));
        }
    }

    private void applyPatchChange(AbstractDelta<String> delta) {
        int pos1 = delta.getSource().getPosition();
        int count1 = delta.getSource().getLines().size();
        int pos2 = delta.getTarget().getPosition();
        int count2 = delta.getTarget().getLines().size();
        int leftOffset = 0;
        int rightOffset = 0;

        if (count1 > count2) {
            rightOffset = count1 - count2;
            for (int i = 0; i < rightOffset; i++) {
                linesRight.add(pos2, new CompareResult.LineCompared("", CHANGE)); // pos2 lub pos2 + 1
            }
        } else if (count2 > count1) {
            leftOffset = count2 - count1;
            for (int i = 0; i < leftOffset; i++) {
                linesLeft.add(pos1, new CompareResult.LineCompared("", CHANGE)); // pos1 lub pos1 + 1
            }
        }

        for (int i = 0; i < count1; i++) {
            if (linesLeft.get(pos1 + leftOffset + i).getType() == null) {
                linesLeft.get(pos1 + leftOffset + i).setType(CHANGE);
            }
        }
        for (int i = 0; i < count2; i++) {
            if (linesRight.get(pos2 + rightOffset + i).getType() == null) {
                linesRight.get(pos2 + rightOffset + i).setType(CHANGE);
            }
        }
    }

    private void postProcess(CompareResult rslt) {
        for(CompareResult.CompareResultRow row : rslt.getRows()) {
            if (row.getLineLeft().getType() == null) {
                if (row.getLineRight().getType() == null) {
                    String sl = "" + row.getLineLeft().getText();
                    String sr = "" + row.getLineRight().getText();
                    if (!sl.equals(sr)) {
                        //row.getLineLeft().setType(CHANGE);
                        //row.getLineRight().setType(CHANGE);
                    }
                }
            }
        }
    }

}
