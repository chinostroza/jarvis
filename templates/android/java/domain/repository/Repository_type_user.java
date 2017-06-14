package {{ app.package }}.domain.repository;

import {{ app.package }}.domain.entity.MessageEntity;
import {{ app.package }}.domain.entity.{{ name|capitalize }}Entity;
import {{ app.package }}.domain.entity.VoidEntity;

import io.reactivex.Observable;

public interface {{ name|capitalize }}Repository {
    Observable<{{ name|capitalize }}Entity> create{{ name|capitalize }}({{ name|capitalize }}Entity {{ name }});
    Observable<VoidEntity> delete{{ name|capitalize }}({{ name|capitalize }}Entity {{ name }});
    Observable<MessageEntity> resetPassword({{ name|capitalize }}Entity {{ name }});

    Observable<{{ name|capitalize }}Entity> login{{ name|capitalize }}({{ name|capitalize }}Entity {{ name }});
    Observable<VoidEntity> logout{{ name|capitalize }}({{ name|capitalize }}Entity {{ name }});
}