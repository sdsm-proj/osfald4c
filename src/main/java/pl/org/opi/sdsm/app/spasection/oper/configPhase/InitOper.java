package pl.org.opi.sdsm.app.spasection.oper.configPhase;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.stru.configPhase.ui.ConfigViewPanel;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class InitOper {

    private final ConfigViewPanel viewPanel;

    public InitOper(ConfigViewPanel viewPanel) {
        this.viewPanel = viewPanel;
        model2View();
    }

    public void exec() {
        viewPanel.getEdProjectRootPath().setText(_SpaSectionGenUtil.getModel().getPrjRootPath());
        setFocusListener(viewPanel.getEdSourceSubPath());
        setFocusListener(viewPanel.getEdTargetSubPath());
        setFocusListener(viewPanel.getTaLookForClassesSubPath());
        setFocusListener(viewPanel.getTaJars());
    }

    private void setFocusListener(JComponent component) {
        component.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                view2Model();
                _SpaSectionGenUtil.getGen().save();
            }
        });
    }

    private void model2View() {
        var config = _SpaSectionGenUtil.getModel().getConfigPrjLevel();
        viewPanel.getEdSourceSubPath().setText(config.getSourceSubPath());
        viewPanel.getEdTargetSubPath().setText(config.getTargetSubPath());
        viewPanel.getTaLookForClassesSubPath().setText(config.getLookForClassesSubPath());
        viewPanel.getTaJars().setText(config.getJars());
    }

    private void view2Model() {
        var config = _SpaSectionGenUtil.getModel().getConfigPrjLevel();
        config.setSourceSubPath(viewPanel.getEdSourceSubPath().getText().trim());
        config.setTargetSubPath(viewPanel.getEdTargetSubPath().getText().trim());
        config.setLookForClassesSubPath(viewPanel.getTaLookForClassesSubPath().getText().trim());
        config.setJars(viewPanel.getTaJars().getText().trim());
    }

}
