package {{ app.package }}.domain.interactor.{{ name }};

import {{ app.package }}.domain.entity.VoidEntity;
import {{ app.package }}.domain.executor.PostExecutionThread;
import {{ app.package }}.domain.executor.ThreadExecutor;
import {{ app.package }}.domain.interactor.UseCase;
import {{ app.package }}.domain.repository.SessionRepository;
import {{ app.package }}.domain.repository.{{ name|capitalize }}Repository;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;

public class Delete{{ name|capitalize }}UseCase extends UseCase<VoidEntity> {

    private {{ name|capitalize }}Repository {{ name }}Repository;
    private SessionRepository sessionRepository;

    @Inject
    public Delete{{ name|capitalize }}UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                             {{ name|capitalize }}Repository userRepository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.{{ name }}Repository = {{ name }}Repository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    protected Observable<VoidEntity> buildUseCaseObservable() {
        return this.{{ name }}Repository.delete{{ name|capitalize }}(this.sessionRepository.getCurrent{{ name|capitalize }}())
                .doOnComplete(new Action() {
                    @Override
                    public void run() {
                        sessionRepository.invalidateSession();
                    }
                });
    }
}
