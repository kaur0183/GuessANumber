/* My app is Guessing number game
 * The purpose of my app to guess a number and if the number that user guessed is equal to the generated random number within first
 ten guesses than user won otherwise he looses.
 * Prabhjot Kaur ( kaur0183@algonquinlive.com)
 */

package com.kaur0183algonquincollege.guessanumber;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int numberOfGuesses;
    private static final String ABOUT_DIALOG_TAG;

    static {
        ABOUT_DIALOG_TAG = "About Dialog";

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOfGuesses = 0;

        Random r = new Random();
        final int theNumber = r.nextInt(1000) + 1;

        final EditText editTextInput = (EditText) findViewById(R.id.editText);


        Button buttonGuess = (Button) findViewById(R.id.button);
        buttonGuess.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final int userGuess = Integer.parseInt(editTextInput.getText().toString()

                );
                numberOfGuesses = numberOfGuesses + 1;
                if (numberOfGuesses < 10) {
                    if (userGuess == theNumber) {
                        if (numberOfGuesses <= 5) {
                            Toast.makeText(getApplicationContext(), "Superior win!", Toast.LENGTH_SHORT).show();
                        } else if (numberOfGuesses > 5 && numberOfGuesses < 10) {
                            Toast.makeText(getApplicationContext(), "Exellent win!", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(getApplicationContext(), userGuess + " is correct", Toast.LENGTH_SHORT).show();
                    } else if (userGuess < theNumber) {
                        Toast.makeText(getApplicationContext(), userGuess + " is too low", Toast.LENGTH_SHORT).show();
                    } else if (userGuess > theNumber) {
                        Toast.makeText(getApplicationContext(), userGuess + " is too high", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please Reset!", Toast.LENGTH_SHORT).show();
                    numberOfGuesses = 0;

                }
            }
        });

        buttonGuess.setOnLongClickListener(new View.OnLongClickListener() {
                                               @Override
                                               public boolean onLongClick(View view) {
                                                   Toast.makeText(getApplicationContext(), "" + theNumber, Toast.LENGTH_SHORT).show();
                                                   return true;
                                               }
                                           }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show(getFragmentManager(), ABOUT_DIALOG_TAG);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
