package com.example.mmart.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mmart.testapp.Objects.MovieAdapter;
import com.example.mmart.testapp.Objects.Movies;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Movies> listMovies = new ArrayList<Movies>();
    public static final int CODE_RETURN = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button btnClick = (Button) findViewById(R.id.buttonTest);
        Button btnListView = (Button) findViewById(R.id.buttonListView);
        Button btnAddMovie = (Button) findViewById(R.id.buttonAddMovie);
        final EditText txtName = (EditText) findViewById(R.id.textTest);
        final EditText txtMovieName = (EditText) findViewById(R.id.textMovieName);
        final EditText txtRuntime = (EditText) findViewById(R.id.textRuntime);
        final EditText txtDirector = (EditText) findViewById(R.id.textDirector);
        final EditText txtGenre = (EditText) findViewById(R.id.textGenre);
        final EditText txtRelease = (EditText) findViewById(R.id.textRelease);

        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);

                String message = txtName.getText().toString();
                intent.putExtra("Mensaje", message);
                startActivity(intent);
            }
        });

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MovieListActivity.class);
                intent.putExtra("Parcel", listMovies);
                //startActivity(intent);
                startActivityForResult(intent, CODE_RETURN);
            }
        });

        btnAddMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtMovieName.getText().toString();
                String runtime = txtRuntime.getText().toString();
                String director = txtDirector.getText().toString();
                String genre = txtGenre.getText().toString();
                String release = txtRelease.getText().toString();
                Movies movie = new Movies(
                    name, runtime,
                    director, genre, release);
                listMovies.add(movie);
                Snackbar.make(view, "Added " + name + " to list", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                //Toast.makeText(getApplicationContext(), "Added " + name + " to list", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == CODE_RETURN) {
            //Swap lists
            listMovies = data.getParcelableArrayListExtra("ReturnParcel");
            //Toast.makeText(getApplicationContext(), "Finished List View activity", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
