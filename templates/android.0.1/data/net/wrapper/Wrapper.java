package {{ app.package }}.data.net.wrapper;

import {{ app.package }}.domain.entity.{{ name|capitalize }};

public class {{ name|capitalize }}Wrapper {

    private {{ name|capitalize }} {{ name }};

    public {{ name|capitalize }}Wrapper({{ name|capitalize }} {{ name }}) {
        this.{{ name }} = {{ name }};
    }

    public {{ name|capitalize }} get{{ name|capitalize }}() {
        return {{ name }};
    }

    public void set{{ name|capitalize }}({{ name|capitalize }} {{ name }}) {
        this.{{ name }} = {{ name }};
    }
}
