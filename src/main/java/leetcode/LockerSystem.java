package leetcode;

/*
* assignLocker(Package p)
* retrievePackage(Package p)
*
*
* Lockers: s, m
* Packages: xs, s, m
*
* Filter
* Params
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LockerSystem {
    enum LockerSize {
        SMALL,
        MEDIUM
    }

    enum PackageSize {
        XS,
        S,
        M
    }

    public static class Locker {
        LockerSize size;
        boolean occupied = false;
        int code;
        Package pkg;

        public Locker(LockerSize size) {
            this.size = size;
        }
    }

    static class Package {
        PackageSize size;
    }

    Map<PackageSize, List<LockerSize>> packageToLockerSize = Map.of(
            PackageSize.XS, List.of(LockerSize.SMALL, LockerSize.MEDIUM),
            PackageSize.S, List.of(LockerSize.SMALL, LockerSize.MEDIUM),
            PackageSize.M, List.of(LockerSize.MEDIUM)
    );

    Map<Integer, Locker> codeToLocker = new HashMap<>();

    static class Params {
        PackageSize packageSize;
        Boolean occupied;
    }

    interface IFilter {
        boolean isValid(Params params, Locker locker);
    }

    class SizeFilter implements IFilter {
        @Override
        public boolean isValid(Params params, Locker locker) {
            if (params.packageSize == null) return true;
            return packageToLockerSize.get(params.packageSize).contains(locker.size);
        }
    }

    class OccupationFilter implements IFilter {
        @Override
        public boolean isValid(Params params, Locker locker) {
            if (params.occupied == null) return true;
            return !locker.occupied;
        }
    }

    class Filter {
        List<IFilter> filters = new ArrayList<>();

        public Filter() {
            filters.add(new SizeFilter());
            filters.add(new OccupationFilter());
        }

        public boolean isValid(Params params, Locker locker) {
            for (IFilter filter: filters) {
                if (!filter.isValid(params, locker)) return false;
            }
            return true;
        }

    }

    List<Locker> lockers;
    Filter filter = new Filter();
    int code = 0;
    LockerSystem(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Locker assignLocker(Package p) {
        Params params = new Params();
        params.packageSize = p.size;
        params.occupied = false;
        for (Locker l : lockers) {
            if (filter.isValid(params, l)) {
                l.occupied = true;
                l.pkg = p;
                codeToLocker.put(code, l);
                code++;
                return l;
            }
        }
        throw new Error("No lockers free");
    }

    public Package retrievePackage(int code) {
        if (codeToLocker.containsKey(code)) {
            Locker locker = codeToLocker.get(code);
            locker.occupied = false;
            return codeToLocker.get(code).pkg;
        } else {
            throw new Error("Wrong code");
        }
    }

}
