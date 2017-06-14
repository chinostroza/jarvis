package {{ app.package }}.domain.interactor.user;

import {{ app.package }}.domain.entity.{{ name|capitalize }}Entity;
import {{ app.package }}.domain.executor.PostExecutionThread;
import {{ app.package }}.domain.executor.ThreadExecutor;
import {{ app.package }}.domain.interactor.UseCase;
import {{ app.package }}.domain.repository.SessionRepository;
import {{ app.package }}.domain.repository.{{ name|capitalize }}Repository;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class DoLoginUseCase extends UseCase<{{ name|capitalize }}Entity> {

    private {{ name|capitalize }}Repository userRepository;
    private SessionRepository sessionRepository;

    private {{ name|capitalize }}Entity user;

    @Inject
    public DoLoginUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                         {{ name|capitalize }}Repository {{ name }}Repository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.{{ name }}Repository = {{ name }}Repository;
        this.sessionRepository = sessionRepository;
    }

    public void setParams({{ name|capitalize }}Entity {{ name }}) {
        this.{{ name }} = {{ name }};
    }

    @Override
    protected Observable<{{ name|capitalize }}Entity> buildUseCaseObservable() {
        return this.{{ name }}Repository.login{{ name|capitalize }}(this.{{ name }})
                .doOnNext(new Consumer<{{ name|capitalize }}Entity>() {
                    @Override
                    public void accept({{ name|capitalize }}Entity userEntity) throws Exception {
                        sessionRepository.setCurrent{{ name|capitalize }}({{ name }}Entity);
                    }
                });
    }
}
