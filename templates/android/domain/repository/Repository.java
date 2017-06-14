package {{ app.package }}.domain.repository;

{% for method in repository_methods %}
import {{ app.package }}.domain.entity.{{ method.return|capitalize }};
{% endfor %}
import io.reactivex.Observable;

public interface {{ name|capitalize }}Repository {
	{% for method in repository_methods %}
    Observable<{{ method.return | capitalize }}> {{ method.name | capitalize }}({% for param in method.params %} {{ param.type|capitalize }} {{ param.name }} {% endfor %});
    {% endfor %}
}