package pl.org.opi.sdsm.app.vuespringsection.util;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class KlazzUtil {

    static public boolean doesClassImplementIface(Class<?> klazz, String ifaceSimpleName) {
        List<Pair<String, String>> ifaces = listOfAllIfacesInclSuper(klazz);
        for(var iface: ifaces) {
            if (ifaceSimpleName.equals(iface.getRight())) {
                return true;
            }
        }
        return false;
    }

    static public List<Pair<String, String>> listOfSuperclasses(Class<?> klazz) {
        Class<?> k = klazz;
        List<Pair<String, String>> names  = new ArrayList<>();

        while (k.getSuperclass() != null) {
            Class<?> sk = k.getSuperclass();
            String canonicalName = sk.getCanonicalName();
            String simpleName = sk.getSimpleName();
            names.add(new ImmutablePair<>(canonicalName, simpleName));
            k = sk;
        }

        return names;
    }

    static public List<Pair<String, String>> listOfAllIfacesInclSuper(Class<?> klazz) {
        if (klazz.getSimpleName().endsWith("List")) {
            int dbg = 1;
        }

        Class<?> k = klazz;
        List<Pair<String, String>> names  = new ArrayList<>();
        names.addAll(listOfIfacesSingleClass(klazz));

        while (k.getSuperclass() != null) {
            Class<?> sk = k.getSuperclass();
            names.addAll(listOfIfacesSingleClass(sk));
            k = sk;
        }

        if (klazz.getSimpleName().equals("Raport")) {
            int dbg = 1;
        }

        return names;
    }

    static public List<Pair<String, String>> listOfIfacesSingleClass(Class<?> klazz) {
        Class<?> k = klazz;
        List<Pair<String, String>> names  = new ArrayList<>();

        for(var iface: klazz.getInterfaces()) {
            String canonicalName = iface.getCanonicalName();
            String simpleName = iface.getSimpleName();
            names.add(new ImmutablePair<>(canonicalName, simpleName));
        }

        if (klazz.getSimpleName().equals("Raport")) {
            int dbg = 1;
        }

        return names;
    }

    static public Set<Class<?>> getAllExtendedOrImplementedInterfacesRecursively(Class<?> clazz) {

        Set<Class<?>> res = new HashSet<Class<?>>();
        Class<?>[] interfaces = clazz.getInterfaces();

        if (interfaces.length > 0) {
            res.addAll(Arrays.asList(interfaces));

            for (Class<?> interfaze : interfaces) {
                res.addAll(getAllExtendedOrImplementedInterfacesRecursively(interfaze));
            }
        }

        return res;
    }

    static public boolean doesExtendClass(Class<?> clazz, String simpleName) {
        List<Pair<String, String>> baseClasses = listOfSuperclasses(clazz);
        for(var k: baseClasses) {
            if (k.getRight().equals(simpleName)) {
                return true;
            }
        }
        return false;
    }

}
