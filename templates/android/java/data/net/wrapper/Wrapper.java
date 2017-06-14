package {{ app.package }}.data.net.wrapper;

import {{ app.package }}.domain.entity.{{ name|capitalize }}Entity;

public class {{ name|capitalize }}Wrapper {

    private {{ name|capitalize }}Entity {{ name }};

    public {{ name|capitalize }}Wrapper({{ name|capitalize }}Entity {{ name }}) {
        this.{{ name }} = {{ name }};
    }

    public {{ name|capitalize }}Entity get{{ name|capitalize }}() {
        return {{ name }};
    }

    public void set{{ name|capitalize }}({{ name|capitalize }}Entity {{ name }}) {
        this.{{ name }} = {{ name }};
    }
}