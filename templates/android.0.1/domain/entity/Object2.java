package {{ app.package }}.domain.entity;

public class {{ name|capitalize }} {

    {% for property in objects.properties %}
    private {{ property.type }} {{ property.name }};
    {% endfor %}

    public {{ name|capitalize }}() {}


    {% for property in objects.properties %}
    public {{ property.type }} get{{ property.name }}() {
        return {{ property.name }};
    }

    public void set{{ property.name }}({{ property.type }} {{ property.name }}) {
        this.{{ property.name }} = {{ property.name }};
    }
    {% endfor %}
}