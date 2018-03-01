import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class {{ entity.name_class }} {

    {% for property in properties %}
    @SerializedName("{{ property.name }}")
    private {{ property.type }} {{ property.name }};
    {% endfor %}

    public {{ entity.name_class }}() {}


    {% for property in properties %}
    public {{ property.type }} get{{ property.name|capitalize }}() {
        return {{ property.name }};
    }

    public void set{{ property.name|capitalize }}({{ property.type }} {{ property.name }}) {
        this.{{ property.name }} = {{ property.name }};
    }
    {% endfor %}
}