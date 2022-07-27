package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SignInAPITests {
    @Test
    public void test_register() {
        SignInAPI sa = new SignInAPI();
        Assertions.assertThat(sa.register("user", "pwd")).isEqualTo("Registered Successfully");
        Assertions.assertThat(sa.login("user", "pwd")).isEqualTo("Logged In Successfully");
    }

    @Test
    public void double_login() {
        SignInAPI sa = new SignInAPI();
        Assertions.assertThat(sa.register("user", "pwd")).isEqualTo("Registered Successfully");
        Assertions.assertThat(sa.login("user", "pwd")).isEqualTo("Logged In Successfully");
        Assertions.assertThat(sa.login("user", "pwd")).isEqualTo("Login Unsuccessful");
    }

    @Test
    public void logout() {
        SignInAPI sa = new SignInAPI();
        Assertions.assertThat(sa.register("user", "pwd")).isEqualTo("Registered Successfully");
        Assertions.assertThat(sa.login("user", "pwd")).isEqualTo("Logged In Successfully");
        Assertions.assertThat(sa.logout("user")).isEqualTo("Logged Out Successfully");
    }

    @Test
    public void logout_with_no_previous_login() {
        SignInAPI sa = new SignInAPI();
        Assertions.assertThat(sa.register("user", "pwd")).isEqualTo("Registered Successfully");
        Assertions.assertThat(sa.logout("user")).isEqualTo("Logout Unsuccessful");
    }

    @Test
    public void logout_after_double_login() {
        SignInAPI sa = new SignInAPI();
        Assertions.assertThat(sa.register("user", "pwd")).isEqualTo("Registered Successfully");
        Assertions.assertThat(sa.login("user", "pwd")).isEqualTo("Logged In Successfully");
        Assertions.assertThat(sa.login("user", "pwd")).isEqualTo("Login Unsuccessful");
        Assertions.assertThat(sa.logout("user")).isEqualTo("Logged Out Successfully");
    }
}
