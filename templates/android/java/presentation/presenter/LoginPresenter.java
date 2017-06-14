package {{ app.package }}.presentation.presenter;

import {{ app.package }}.domain.entity.{{ name|capitalize }}Entity;
import {{ app.package }}.domain.interactor.{{ name }}.DoLoginUseCase;
import {{ app.package }}.presentation.dependency.ActivityScope;
import {{ app.package }}.presentation.view.BaseView;
import {{ app.package }}.presentation.view.LoginView;

import javax.inject.Inject;

@ActivityScope
public class LoginPresenter extends BasePresenter implements Presenter {

    private DoLoginUseCase doLoginUseCase;
    LoginView loginView;

    @Inject
    public LoginPresenter(DoLoginUseCase doLoginUseCase) {
        super(doLoginUseCase);
        this.doLoginUseCase = doLoginUseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.loginView = (LoginView) view;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.loginView = null;
    }

    public void login{{ name|capitalize }}(String email, String password) {
        {{ name|capitalize }}Entity {{ name }} = new {{ name|capitalize }}Entity(email);
        {{ name }}.setPassword(password);

        this.showLoader();
        this.doLoginUseCase.setParams({{ name }});
        this.doLoginUseCase.execute(new LoginSubscriber());
    }

    protected class LoginSubscriber extends BaseSubscriber<{{ name|capitalize }}Entity> {

        @Override
        public void onNext({{ name|capitalize }}Entity {{ name }}) {
            LoginPresenter.this.hideLoader();
            LoginPresenter.this.loginView.viewNotes();
        }

    }

}
