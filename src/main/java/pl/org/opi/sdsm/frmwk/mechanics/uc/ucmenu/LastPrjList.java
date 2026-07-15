package pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LastPrjList {

    public void afterPrjOpened(String prjFileName) {
        Properties props = readProperties();
        Properties props2 = numerujWpisyOdDwa(props, prjFileName);
        try {
            props2.store(new FileWriter(getPropsFile()), "");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<String> lastFileList() {
        List<String> rslt = new ArrayList<>();
        Properties props = readProperties();
        SortedMap<Integer, String> sortedMap = new TreeMap<>();

        // Posortuj istniejące wg. klucza - numeru
        for(Object key: props.keySet()) {
            try {
                int keyNum = Integer.parseInt((String) key);
                String val = (String)props.get(key);
                sortedMap.put(keyNum, val);
            } catch(Exception ex) {
                //
            }
        }

        Iterator iterator = sortedMap.keySet().iterator();
        while(iterator.hasNext()) {
            Object key   = iterator.next();
            String value = (String) sortedMap.get(key);
            rslt.add(value);
        }

        return rslt;
    }

    private File getPropsFile() {
        String fileName = System.getProperty("user.home") + "/.osfald-last-prj-list.properties";
        return new File(fileName);
    }

    private Properties readProperties() {
        Properties props = new Properties();
        if (getPropsFile().exists()) {
            try (FileInputStream fis = new FileInputStream(getPropsFile())) {
                props.load(fis);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return props;
    }

    private Properties numerujWpisyOdDwa(Properties props, String currPrjFileName) {
        Properties rslt = new Properties();
        SortedMap<Integer, String> sortedMap = new TreeMap<>();

        // Posortuj istniejące wg. klucza - numeru
        for(Object key: props.keySet()) {
            try {
                int keyNum = Integer.parseInt((String) key);
                String val = (String)props.get(key);
                if (val.equals(currPrjFileName) == false) {
                    sortedMap.put(keyNum, val);
                }
            } catch(Exception ex) {
                //
            }
        }

        // Wstaw aktualny jako 1
        rslt.put("1", currPrjFileName);

        // A pozostałe od 2
        Iterator iterator = sortedMap.keySet().iterator();
        int cnt = 2;
        while(iterator.hasNext()) {
            Object key   = iterator.next();
            String value = (String) sortedMap.get(key);
            rslt.put("" + cnt, value);
            cnt++;
        }

        return rslt;
    }

}
