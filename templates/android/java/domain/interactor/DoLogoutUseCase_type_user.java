package {{ app.package }}.domain.interactor.{{ name }};

import {{ app.package }}.domain.entity.{{ name|capitalize }}Entity;
import {{ app.package }}.domain.entity.VoidEntity;
import {{ app.package }}.domain.executor.PostExecutionThread;
import {{ app.package }}.domain.executor.ThreadExecutor;
import {{ app.package }}.domain.interactor.UseCase;
import {{ app.package }}.domain.repository.SessionRepository;
import {{ app.package }}.domain.repository.{{ name|capitalize }}Repository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DoLogout{{ name|capitalize }}UseCase extends UseCase<VoidEntity> {

    private {{ name|capitalize }}Repository {{ name }}Repository;
    private SessionRepository sessionRepository;

    @Inject
    public DoLogout{{ name|capitalize }}UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                           {{ name|capitalize }}Repository {{ name }}Repository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.{{ name }}Repository = {{ name }}Repository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    protected Observable<VoidEntity> buildUseCaseObservable() {
        {{ name|capitalize }}Entity current{{ name|capitalize }} = this.sessionRepository.getCurrent{{ name|capitalize }}();
        this.sessionRepository.invalidateSession();
        return this.{{ name }}Repository.logout{{ name|capitalize }}(current{{ name|capitalize }});
    }
}
