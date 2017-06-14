package {{ app.package }}.domain.entity;

public class {{ name|capitalize }} {

    {% for property in properties %}
    private {{ property.type }} {{ property.name }};
    {% endfor %}

    public {{ name|capitalize }}() {}


    {% for property in properties %}
    public {{ property.type }} get{{ property.name }}() {
        return {{ property.name }};
    }

    public void set{{ property.name }}({{ property.type }} {{ property.name }}) {
        this.{{ property.name }} = {{ property.name }};
    }
    {% endfor %}
}
