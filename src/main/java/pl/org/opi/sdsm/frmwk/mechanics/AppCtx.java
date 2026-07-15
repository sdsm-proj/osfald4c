package pl.org.opi.sdsm.frmwk.mechanics;

import lombok.Getter;

@Getter
public class AppCtx {

    private static AppCtx instance;

    public static void init(MainWindow mw) {
        instance = new AppCtx(mw);
    }

    public static AppCtx getInstance() {
        return instance;
    }

    private AppCtx(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    private final MainWindow mainWindow;

}
