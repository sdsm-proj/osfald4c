package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaNode {

    public enum EnumFldVariant {
        PRIMITIVE,
        SIMPLE,
        DOMAIN_OBJECT,
        OTHER_OBJECT,
        ENUM,
        LOCAL_DICTIONARY_ITEM_INPUT,
        LOCAL_DICTIONARY_ITEM_OUTPUT,
        LOCAL_DICTIONARY_ITEM_REF,
        LIST
    }

    private MetaNode parentNode;
    private EnumFldVariant variant;
    private EnumFldVariant variantGenericType;
    private String fldName;
    private Class<?> fldClass;
    private String fldClassSimpleName;
    private String fldClassCanonicalName;

    private final List<MetaNode> subs = new ArrayList<>();

    public void showMe() {
        System.out.println("*****************************************************************************************");
        showNodeRcr(this, 0);
        System.out.println("*****************************************************************************************");
    }

    public List<MetaNode> getObjectNodes() {
        List<MetaNode> rslt = new ArrayList<>();
        getObjectNodesRcr(this, rslt);

//        System.out.println("******* OBJECT NODES ********************************************************************");
//        for (var on : rslt) {
//            System.out.println(on.getFldClassCanonicalName());
//        }
//        System.out.println("*****************************************************************************************");

        return rslt;
    }

    public String getPrefixedSimpleName() {
        String s = this.fldClassSimpleName;
        MetaNode _parent = this.getParentNode();
        while (_parent != null) {
           s = _parent.getFldClassSimpleName() + s;
            if (_parent == _parent.getParentNode() || _parent.getParentNode() == null) {
                _parent = null;
            } else {
                _parent = _parent.getParentNode();
            }
        }
        return s;
    }

    public String getFldNamesChain() {
        String s = this.fldName;
        MetaNode _parent = this.getParentNode();
        while (_parent != null) {
            s = _parent.getFldName() + "." + s;
            if (_parent == _parent.getParentNode() || _parent.getParentNode() == null) {
                _parent = null;
            } else {
                _parent = _parent.getParentNode();
            }
        }
        return s;
    }

    private void getObjectNodesRcr(MetaNode node, List<MetaNode> objectNodes) {
        if ((EnumFldVariant.DOMAIN_OBJECT.equals(node.getVariant())) || (EnumFldVariant.DOMAIN_OBJECT.equals(node.getVariantGenericType()))) {
            objectNodes.add(node);
        }
        for (MetaNode sub : node.getSubs()) {
            getObjectNodesRcr(sub, objectNodes);
        }
    }

    private void showNodeRcr(MetaNode node, int margin) {
        String s = StringUtils.repeat(" ", margin * 4);
        s += node.fldName + ": ";
        if (node.variant.equals(EnumFldVariant.LIST)) {
            s += "List<";
            s += node.fldClassSimpleName;
            s += "> ";
        } else {
            s += node.fldClassSimpleName;
            s += " ";
        }
        s += ("[" + node.variant + "]");
        if (node.parentNode == null) {
            s += " <ROOT>";
        }
        System.out.println(s);

        for (MetaNode sub : node.getSubs()) {
            showNodeRcr(sub, (margin + 1));
        }
    }

    @Override
    public String toString() {
        String s = "";
        s += this.fldName + ": ";
        if (this.variant.equals(EnumFldVariant.LIST)) {
            s += "List<";
            s += this.fldClassSimpleName;
            s += "> ";
        } else {
            s += this.fldClassSimpleName;
            s += " ";
        }
        s += ("   [" + this.variant + "]");
        if (this.parentNode == null) {
            //s += " <ROOT>";
        }
        return s;
    }

}
