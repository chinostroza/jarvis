package {{ app.package }}.data.net;

{% for object in objects %}
import {{ app.package }}.data.net.wrapper.{{object.name|capitalize}}Wrapper;
import {{ app.package }}.domain.entity.{{object.name|capitalize}};
{% endfor %}

import java.util.List;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import io.reactivex.Observable;

public interface RestApi {

    String URL_BASE = "{{ api.url_base }}";
    int API_VERSION = {{ api.version }};
    String VERSION_HEADER = "{{ api.version_header }}" + API_VERSION;

    {% for resource in api.resources %}
    @{{ resource.http_method }}("{{ resource.url }}")
    Observable<Response<{{ resource.response }}>> {{ resource.method }}(
        {% for param in resource.params %}
        {% if loop.last %}
        {% autoescape false %}{{ param.decorator }}{% endautoescape %} {{ param.type }} {{ param.name }}
        {% else %}
        {% autoescape false %}{{ param.decorator }}{% endautoescape %} {{ param.type }} {{ param.name }},
        {% endif %}
        {% endfor %});

    {% endfor %}
}
