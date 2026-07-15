package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.java;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;

public class _CalcGenVars {

    private ModelAccess mda = new ModelAccess();

    public void exec() {
        calcVars(_SpaSectionGenUtil.getModel().getOperCache().getSelectedSectionPart());
    }

    protected void calcVars(MetaNode metaNode) {
        {
            mda.getGenVars().setJavaInputFullPackage(mda.getConfigDocLevel().getJavaDtoPackage() + "." + mda.getEditSectionLevel().getSelectedSectionPartialPackage());
            mda.getGenVars().setJavaOutputFullPackage(mda.getConfigDocLevel().getJavaDtoPackage() + "." + mda.getEditSectionLevel().getSelectedSectionPartialPackage());
        }
        {
            String serviceIface = "";
            serviceIface += mda.getConfigDocLevel().getJavaDocumentPrefix();
            serviceIface += mda.getEditSectionLevel().getServiceOperationNameUpper();
            serviceIface += mda.getEditSectionLevel().getSelectedSectionPartialPackageUpper();
            serviceIface += "Service";

            {
                mda.getGenVars().getJavaServiceIfaceClassDef().setSimpleClass(serviceIface);
                mda.getGenVars().getJavaServiceIfaceClassDef().setFullPackage(mda.getConfigDocLevel().getJavaServicePackage()
                        + "."
                        + mda.getEditSectionLevel().getSelectedSectionPartialPackage());
                mda.getGenVars().getJavaServiceIfaceClassDef().setFullClass(mda.getGenVars().getJavaServiceIfaceClassDef().getFullPackage()
                        + "."
                        + mda.getGenVars().getJavaServiceIfaceClassDef().getSimpleClass());
                mda.getGenVars().getJavaServiceIfaceClassDef().setFullFileName(_JavaGenUtils.fullClassName2FullFileName(mda.getGenVars().getJavaServiceIfaceClassDef().getFullClass()));
            }
            {
                String serviceImpl = serviceIface + "Impl";
                mda.getGenVars().getJavaServiceImplClassDef().setSimpleClass(serviceImpl);
                mda.getGenVars().getJavaServiceImplClassDef().setFullPackage(mda.getConfigDocLevel().getJavaServicePackage()
                        + "."
                        + mda.getEditSectionLevel().getSelectedSectionPartialPackage());
                mda.getGenVars().getJavaServiceImplClassDef().setFullClass(mda.getGenVars().getJavaServiceImplClassDef().getFullPackage()
                        + "."
                        + mda.getGenVars().getJavaServiceImplClassDef().getSimpleClass());
                mda.getGenVars().getJavaServiceImplClassDef().setFullFileName(_JavaGenUtils.fullClassName2FullFileName(mda.getGenVars().getJavaServiceImplClassDef().getFullClass()));
            }
        }
        {
            String cntr = "";
            cntr += mda.getConfigDocLevel().getJavaDocumentPrefix();
            cntr += mda.getEditSectionLevel().getServiceOperationNameUpper();
            cntr += mda.getEditSectionLevel().getSelectedSectionPartialPackageUpper();
            cntr += "Controller";

            mda.getGenVars().getJavaControllerClassDef().setSimpleClass(cntr);
            mda.getGenVars().getJavaControllerClassDef().setFullPackage(mda.getConfigDocLevel().getJavaControllerPackage()
                    + "."
                    + mda.getEditSectionLevel().getSelectedSectionPartialPackage());
            mda.getGenVars().getJavaControllerClassDef().setFullClass(mda.getGenVars().getJavaControllerClassDef().getFullPackage()
                    + "."
                    + mda.getGenVars().getJavaControllerClassDef().getSimpleClass());
            mda.getGenVars().getJavaControllerClassDef().setFullFileName(_JavaGenUtils.fullClassName2FullFileName(mda.getGenVars().getJavaControllerClassDef().getFullClass()));
            mda.getGenVars().setJavaControllerMethodName(mda.getEditSectionLevel().getRolePrefix()
                    + mda.getConfigDocLevel().getJavaDocumentPrefix()
                    + mda.getEditSectionLevel().getServiceOperationNameUpper()
                    + mda.getEditSectionLevel().getSelectedSectionPartialPackageUpper()
            );
        }
        {
            mda.getGenVars().setJavaMapperFullPackage(mda.getConfigDocLevel().getJavaMapperPackage() + "." + mda.getEditSectionLevel().getSelectedSectionPartialPackage());
            {
                mda.getGenVars().getJavaInputMapper().setSimpleClass(mda.getEditSectionLevel().getDomainSimpleClass() + "InputMapper");
                mda.getGenVars().getJavaInputMapper().setFullPackage(mda.getGenVars().getJavaMapperFullPackage());
                mda.getGenVars().getJavaInputMapper().setFullClass(mda.getGenVars().getJavaInputMapper().getFullPackage()
                        + "."
                        + mda.getGenVars().getJavaInputMapper().getSimpleClass());
                mda.getGenVars().getJavaInputMapper().setFullFileName(_JavaGenUtils.fullClassName2FullFileName(mda.getGenVars().getJavaInputMapper().getFullClass()));
            }
            {
                mda.getGenVars().getJavaOutputMapper().setSimpleClass(mda.getEditSectionLevel().getDomainSimpleClass() + "OutputMapper");
                mda.getGenVars().getJavaOutputMapper().setFullPackage(mda.getGenVars().getJavaMapperFullPackage());
                mda.getGenVars().getJavaOutputMapper().setFullClass(mda.getGenVars().getJavaOutputMapper().getFullPackage()
                        + "."
                        + mda.getGenVars().getJavaOutputMapper().getSimpleClass());
                mda.getGenVars().getJavaOutputMapper().setFullFileName(_JavaGenUtils.fullClassName2FullFileName(mda.getGenVars().getJavaOutputMapper().getFullClass()));
            }
        }
    }

}
