package {{ app.package }}.presentation.view.fragment;

import android.widget.EditText;

import {{ app.package }}.presentation.R;
import {{ app.package }}.presentation.presenter.BasePresenter;
import {{ app.package }}.presentation.presenter.Login{{ name|capitalize }}Presenter;
import {{ app.package }}.presentation.view.Login{{ name|capitalize }}View;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

public class Login{{ name|capitalize }}Fragment extends BaseFragment implements Login{{ name|capitalize }}View {

    @Inject
    Login{{ name|capitalize }}Presenter login{{ name|capitalize }}Presenter;

    @Bind(R.id.et_{{ name }}_email) EditText email{{ name|capitalize }}EditText;
    @Bind(R.id.et_{{ name }}_password) EditText password{{ name|capitalize }}EditText;

    @Override
    protected void callInjection() {
        this.getFragmentInjector().inject(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_{{ name }}_login;
    }

    @Override
    public BasePresenter presenter() {
        return this.login{{ name|capitalize }}Presenter;
    }

    public Login{{ name|capitalize }}Presenter getLogin{{ name|capitalize }}Presenter() {
        return login{{ name|capitalize }}Presenter;
    }

    @OnClick(R.id.btn_{{ name|capitalize }}_login)
    public void login{{ name|capitalize }}ButtonPressed() {
        this.login{{ name|capitalize }}Presenter.login{{ name|capitalize }}(  email{{ name|capitalize }}EditText.getText().toString(),
                                        password{{ name|capitalize }}EditText.getText().toString());
    }

    @Override
    public void viewNotes() {
        ((Listener)getActivity()).viewNotes();
    }

    @OnClick(R.id.btn_register_{{ name }})
    public void register{{ name|capitalize }}ButtonPressed() {
        ((Listener)getActivity()).displayRegister();
    }

    @OnClick(R.id.tv_forgot_password_{{ name }})
    public void forgotPassword{{ name|capitalize }}Pressed() {
        ((Listener)getActivity()).forgotPassword{{ name|capitalize }}();
    }

    public interface Listener {
        void viewNotes();
        void displayRegister{{ name|capitalize }}();
        void forgotPassword{{ name|capitalize }}();
    }
}
