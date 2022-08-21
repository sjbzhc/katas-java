package leetcode;

import org.junit.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class LockerSystemTests {
    @Test
    public void test() {
        LockerSystem.Locker l1 = new LockerSystem.Locker(LockerSystem.LockerSize.SMALL);
        LockerSystem.Locker l2 = new LockerSystem.Locker(LockerSystem.LockerSize.MEDIUM);
        List<LockerSystem.Locker> lockers = List.of(l1, l2);
        LockerSystem ls = new LockerSystem(lockers);

        LockerSystem.Package pkg = new LockerSystem.Package();
        pkg.size = LockerSystem.PackageSize.S;

        Assertions.assertThat(ls.assignLocker(pkg)).isEqualTo(l1);
    }

    @Test
    public void test_retrieve() {
        LockerSystem.Locker l1 = new LockerSystem.Locker(LockerSystem.LockerSize.SMALL);
        LockerSystem.Locker l2 = new LockerSystem.Locker(LockerSystem.LockerSize.MEDIUM);
        List<LockerSystem.Locker> lockers = List.of(l1, l2);
        LockerSystem ls = new LockerSystem(lockers);

        LockerSystem.Package pkg = new LockerSystem.Package();
        pkg.size = LockerSystem.PackageSize.S;

        Assertions.assertThat(ls.assignLocker(pkg)).isEqualTo(l1);

        Assertions.assertThat(ls.retrievePackage(0)).isEqualTo(pkg);
    }

    @Test
    public void test_too_many_medium_packages() {
        LockerSystem.Locker l1 = new LockerSystem.Locker(LockerSystem.LockerSize.SMALL);
        List<LockerSystem.Locker> lockers = List.of(l1);
        LockerSystem ls = new LockerSystem(lockers);

        LockerSystem.Package pkg = new LockerSystem.Package();
        pkg.size = LockerSystem.PackageSize.M;

        Assertions.assertThat(ls.assignLocker(pkg)).isEqualTo("No lockers free");
    }

    @Test
    public void test_multiple_assignments() {
        LockerSystem.Locker l1 = new LockerSystem.Locker(LockerSystem.LockerSize.SMALL);
        LockerSystem.Locker l2 = new LockerSystem.Locker(LockerSystem.LockerSize.SMALL);
        LockerSystem.Locker l3 = new LockerSystem.Locker(LockerSystem.LockerSize.MEDIUM);
        List<LockerSystem.Locker> lockers = List.of(l1, l2, l3);
        LockerSystem ls = new LockerSystem(lockers);

        LockerSystem.Package pkg = new LockerSystem.Package();
        pkg.size = LockerSystem.PackageSize.S;

        Assertions.assertThat(ls.assignLocker(pkg)).isEqualTo(l1);

        LockerSystem.Package pkg2 = new LockerSystem.Package();
        pkg.size = LockerSystem.PackageSize.S;

        Assertions.assertThat(ls.assignLocker(pkg2)).isEqualTo(l2);

        LockerSystem.Package pkg3 = new LockerSystem.Package();
        pkg.size = LockerSystem.PackageSize.M;

        Assertions.assertThat(ls.assignLocker(pkg3)).isEqualTo(l3);

        LockerSystem.Package pkg4 = new LockerSystem.Package();
        pkg.size = LockerSystem.PackageSize.M;

        Assertions.assertThat(ls.assignLocker(pkg4)).isEqualTo(l3);
    }

}
