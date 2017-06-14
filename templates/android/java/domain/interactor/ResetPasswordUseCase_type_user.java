package {{ app.package }}.domain.interactor.{{ name }};

import {{ app.package }}.domain.entity.MessageEntity;
import {{ app.package }}.domain.entity.{{ name|capitalize }}Entity;
import {{ app.package }}.domain.executor.PostExecutionThread;
import {{ app.package }}.domain.executor.ThreadExecutor;
import {{ app.package }}.domain.interactor.UseCase;
import {{ app.package }}.domain.repository.SessionRepository;
import {{ app.package }}.domain.repository.{{ name|capitalize }}Repository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ResetPassword{{ name|capitalize }}UseCase extends UseCase<MessageEntity> {

    private {{ name|capitalize }}Repository {{ name }}Repository;
    private SessionRepository sessionRepository;

    private {{ name|capitalize }}Entity {{ name }};

    @Inject
    public ResetPassword{{ name|capitalize }}UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                {{ name|capitalize }}Repository {{ name }}Repository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.{{ name }}Repository = {{ name }}Repository;
        this.sessionRepository = sessionRepository;
    }

    public void setParams({{ name|capitalize }}Entity {{ name }}) {
        this.{{ name }} = {{ name }};
    }

    @Override
    protected Observable<MessageEntity> buildUseCaseObservable() {
        if (this.{{ name }} == null) this.{{ name }} = sessionRepository.getCurrent{{ name|capitalize }}();
        return this.{{ name }}Repository.resetPassword(this.{{ name }});
    }
}
