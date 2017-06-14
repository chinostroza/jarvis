package {{ app.package }}.presentation.presenter;

import {{ app.package }}.domain.entity.{{ name|capitalize }}Entity;
import {{ app.package }}.domain.interactor.{{ name }}.Create{{ name|capitalize }}UseCase;
import {{ app.package }}.presentation.dependency.ActivityScope;
import {{ app.package }}.presentation.view.BaseView;
import {{ app.package }}.presentation.view.RegisterView;

import javax.inject.Inject;

@ActivityScope
public class RegisterPresenter extends BasePresenter implements Presenter {

    private Create{{ name|capitalize }}UseCase create{{ name|capitalize }}UseCase;
    RegisterView registerView;

    @Inject
    public RegisterPresenter(Create{{ name|capitalize }}UseCase create{{ name|capitalize }}UseCase) {
        super(create{{ name|capitalize }}UseCase);
        this.create{{ name|capitalize }}UseCase = create{{ name|capitalize }}UseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.registerView = (RegisterView) view;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.registerView = null;
    }

    public void register{{ name|capitalize }}(String email, String password, String passwordConfirmation) {
        {{ name|capitalize }}Entity {{ name }} = new {{ name|capitalize }}Entity(email);
        {{ name }}.setPassword(password);
        {{ name }}.setPasswordConfirmation(passwordConfirmation);

        this.showLoader();
        this.create{{ name|capitalize }}UseCase.setParams({{ name }});
        this.create{{ name|capitalize }}UseCase.execute(new RegisterSubscriber());
    }

    protected class RegisterSubscriber extends BaseSubscriber<{{ name|capitalize }}Entity> {

        @Override
        public void onNext({{ name|capitalize }}Entity {{ name }}) {
            RegisterPresenter.this.hideLoader();
            RegisterPresenter.this.registerView.viewNotes();
        }

    }

}
