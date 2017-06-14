package {{ app.package }}.data.repository;

import {{ app.package }}.data.net.RestApi;
import {{ app.package }}.data.net.wrapper.{{ name|capitalize }}Wrapper;
import {{ app.package }}.domain.entity.MessageEntity;
import {{ app.package }}.domain.entity.{{ name|capitalize }}Entity;
import {{ app.package }}.domain.entity.VoidEntity;
import {{ app.package }}.domain.repository.{{ name|capitalize }}Repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import retrofit2.Response;

@Singleton
public class {{ name|capitalize }}DataRepository extends RestApiRepository implements {{ name|capitalize }}Repository {

    private final RestApi restApi;

    @Inject
    public {{ name|capitalize }}DataRepository(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<{{ name|capitalize }}Entity> create{{ name|capitalize }}({{ name|capitalize }}Entity {{ name }}) {
        return this.restApi.create{{ name|capitalize }}(new {{ name|capitalize }}Wrapper({{ name }}))
                .map({{ name }}EntityResponse -> {
                    handleResponseError({{ name }}EntityResponse);
                    return {{ name }}EntityResponse.body();
                });
    }

    @Override
    public Observable<VoidEntity> delete{{ name|capitalize }}(final {{ name|capitalize }}Entity {{ name }}) {
        return this.restApi.delete{{ name|capitalize }}({{ name }}.getAuthToken())
                .map(voidResponse -> {
                    handleResponseError(voidResponse);
                    return new VoidEntity();
                });
    }

    @Override
    public Observable<MessageEntity> resetPassword({{ name|capitalize }}Entity {{ name }}) {
        return this.restApi.resetPassword({{ name }}.getAuthToken(), new {{ name|capitalize }}Wrapper({{ name }}))
                .map(messageEntityResponse -> {
                    handleResponseError(messageEntityResponse);
                    return messageEntityResponse.body();
                });
    }

    @Override
    public Observable<{{ name|capitalize }}Entity> login{{ name|capitalize }}({{ name|capitalize }}Entity {{ name }}) {
        return this.restApi.doLogin(new {{ name|capitalize }}Wrapper({{ name }}))
                .map({{ name }}EntityResponse -> {
                    handleResponseError({{ name }}EntityResponse);
                    return {{ name }}EntityResponse.body();
                });
    }

    @Override
    public Observable<VoidEntity> logout{{ name|capitalize }}({{ name|capitalize }}Entity {{ name }}) {
        return this.restApi.doLogout({{ name }}.getAuthToken())
                .map(voidResponse -> {
                    handleResponseError(voidResponse);
                    return new VoidEntity();
                });
    }
}
