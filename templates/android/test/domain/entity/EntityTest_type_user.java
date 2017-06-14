package {{ app.package }}.domain.entity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class {{ name|capitalize }}EntityTest {

    private static final String FAKE_EMAIL = "email@test.com";

    private {{ name|capitalize }}Entity {{ name }};

    @Before
    public void setup() {
        this.{{ name }} = new {{ name|capitalize }}Entity(FAKE_EMAIL);
    }

    @Test
    public void test{{ name|capitalize }}Constructor() {
        assertThat(this.{{ name }}.getEmail(), is(FAKE_EMAIL));
    }

    @Test
    public void test{{ name|capitalize }}Setters() {
        this.{{ name }}.setEmail("another@email.com");
        this.{{ name }}.setAuthToken("1234TOKEN");
        this.{{ name }}.setPassword("password");
        this.{{ name }}.setPasswordConfirmation("conf_password");
        this.{{ name }}.setNewPassword("new_password");
        this.{{ name }}.setNewPasswordConfirmation("new_conf_password");

        assertThat(this.{{ name }}.getEmail(), is("another@email.com"));
        assertThat(this.{{ name }}.getAuthToken(), is("1234TOKEN"));
        assertThat(this.{{ name }}.getPassword(), is("password"));
        assertThat(this.{{ name }}.getPasswordConfirmation(), is("conf_password"));
        assertThat(this.{{ name }}.getNewPassword(), is("new_password"));
        assertThat(this.{{ name }}.getNewPasswordConfirmation(), is("new_conf_password"));
    }
}
