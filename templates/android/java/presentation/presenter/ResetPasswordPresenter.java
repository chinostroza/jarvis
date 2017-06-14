package {{ app.package }}.presentation.presenter;

import {{ app.package }}.domain.entity.MessageEntity;
import {{ app.package }}.domain.entity.{{ name|capitalize }}Entity;
import {{ app.package }}.domain.interactor.{{ name }}.ResetPasswordUseCase;
import {{ app.package }}.presentation.dependency.ActivityScope;
import {{ app.package }}.presentation.view.BaseView;
import {{ app.package }}.presentation.view.ResetPasswordView;

import javax.inject.Inject;

@ActivityScope
public class ResetPasswordPresenter extends BasePresenter implements Presenter {

    private ResetPasswordUseCase resetPasswordUseCase;
    ResetPasswordView resetPasswordView;

    @Inject
    public ResetPasswordPresenter(ResetPasswordUseCase resetPasswordUseCase) {
        super(resetPasswordUseCase);
        this.resetPasswordUseCase = resetPasswordUseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.resetPasswordView = (ResetPasswordView) view;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.resetPasswordView = null;
    }

    public void resetPassword(String email, String newPassword, String newPasswordConfirmation) {
        {{ name|capitalize }}Entity {{ name }} = new {{ name|capitalize }}Entity(email);
        {{ name }}.setNewPassword(newPassword);
        {{ name }}.setNewPasswordConfirmation(newPasswordConfirmation);

        this.showLoader();
        this.resetPasswordUseCase.setParams({{ name }});
        this.resetPasswordUseCase.execute(new ResetPasswordSubscriber());
    }

    protected class ResetPasswordSubscriber extends BaseSubscriber<MessageEntity> {

        @Override
        public void onNext(MessageEntity message) {
            ResetPasswordPresenter.this.hideLoader();
            ResetPasswordPresenter.this.resetPasswordView.showMessage(message.getMessage());
            ResetPasswordPresenter.this.resetPasswordView.close();
        }

    }

}
