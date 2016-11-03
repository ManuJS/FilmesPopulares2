package com.manu.projeto.filmespopulares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.manu.projeto.filmespopulares.R;
import com.manu.projeto.filmespopulares.models.Filme;

public class MainActivity extends AppCompatActivity implements FragmentMain.Callback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_main, new FragmentMain())
                    .commit();
        }
    }

    @Override
    public void onItemSelected(Filme filme) {
        Intent intent = new Intent(this, MovieDetailActivity.class)
                .putExtra(FragmentMain.DETAIL_MOVIE, filme);
        startActivity(intent);
    }
}
