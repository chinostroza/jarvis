package cl.multicaja.comercio.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import cl.multicaja.comercio.presentation.R;
import cl.multicaja.comercio.presentation.view.activity.base.CleanActivity;
import cl.multicaja.comercio.presentation.view.fragment.{{ activity.name_class }}Fragment;


/**
 * Created by chinostroza {{ now|date('Y-m-d') }}
 */

public class {{ activity.name_class }}Activity extends CleanActivity implements {{ activity.name_class }}Fragment.Listener {
    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        logoToolbar = false;
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new {{ activity.name_class }}Fragment());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_gohome, menu);
        this.getToolbar().setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
                return true;
            }
        });
        return true;
    }


    @Override
    public void show{{ nextactivity.name_class }}( {{ nextactivityparams|joinParams(', ') }} ) {
        finish();
    }
}
