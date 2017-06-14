package {{ app.package }}.domain.repository;


{% for property in properties %}
import {{ app.package }}.domain.entity.{{ name|capitalize }};
{% endfor %}

import io.reactivex.Observable;

public interface {{ name|capitalize }}Repository {
	{% for method in repository_methods %}
    Observable<UserEntity> {{ method.name }} (UserEntity user);
    {% endfor %}
    Observable<VoidEntity> deleteUser(UserEntity user);
    Observable<MessageEntity> resetPassword(UserEntity user);

    Observable<UserEntity> loginUser(UserEntity user);
    Observable<VoidEntity> logoutUser(UserEntity user);
}