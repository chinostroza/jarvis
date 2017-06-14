package {{ app.package }}.domain.entity;

public class {{ name }} {

    {% for property in properties %}
    private {{ property.type }} {{ property.name }};
    {% endfor %}

    public {{ name }}() {}


    {% for property in properties %}
    public {{ property.type }} get{{ property.name|capitalize }}() {
        return {{ property.name }};
    }

    public void set{{ property.name|capitalize }}({{ property.type }} {{ property.name }}) {
        this.{{ property.name }} = {{ property.name }};
    }
    {% endfor %}
}