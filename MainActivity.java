/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends FragmentActivity 
        implements HeadlinesFragment.OnHeadlineSelectedListener {

    // This one converts to Celsius
    Button toC;
    // This one converts to Fahrenheit
    Button toF;
    // This one shows the text in Ipsum
    Button show;

    // Celsius Conversion Function
    public double intoC (double num) {
        double formula = ((num - 32) * 5) / 9;
        return formula;
    }

    // Fahrenheit Conversion Function
    public double intoF (double num) {
        double formula = (num * 1.8) + 32;
        return formula;
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

    }

    public void onArticleSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment

        // Sets a hint into the user input box
        EditText edit = (EditText) findViewById(R.id.editText);
        TextView view = (TextView) findViewById(R.id.textView);
        edit.setHint("Enter the temperature");
        view.setText("Result...");

        if (position == 0) {
            // Sets the button to the appropriate text in the Headline
            toC = (Button) findViewById(R.id.button);

            // Makes the button and text visible
            toC.setVisibility(View.VISIBLE);
            EditText entree = (EditText) findViewById(R.id.editText);
            entree.setVisibility(View.VISIBLE);
            TextView result = (TextView) findViewById(R.id.textView);
            result.setVisibility(View.VISIBLE);

            toC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View input) {
                    // Creates entree1 to place the user input
                    EditText entree1 = (EditText) findViewById(R.id.editText);

                    // Creates result1 to place the output
                    TextView result1 = (TextView) findViewById(R.id.textView);

                    try {
                        // Takes the input as a double
                        double entree = Double.parseDouble(entree1.getText().toString());

                        // Sends the input to intoC function
                        double result = intoC(entree);

                        // Places the value from the result (output from intoC function) in the output string
                        String output = Double.toString(result);

                        // Shows the conversion
                        result1.setText("Temperature " + entree + " (F) is " + output + " (C)");
                    }
                    catch (NumberFormatException nfe) {
                        result1.setText("Invalid numerical input");
                    }
                    catch (Exception e) {
                        result1.setText("Unspecified exception, but not NFE");
                    }

                    // Removes the user input from the entree1
                    entree1.setText(null);
                }
            }
            );
        }

        if (position == 1) {
            // Sets the button to the appropriate text in the Headline
            toF = (Button) findViewById(R.id.button);

            // Makes the button and text visible
            toF.setVisibility(View.VISIBLE);
            EditText entree = (EditText) findViewById(R.id.editText);
            entree.setVisibility(View.VISIBLE);
            TextView result = (TextView) findViewById(R.id.textView);
            result.setVisibility(View.VISIBLE);

            toF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View input) {
                    // Creates entree2 to place the user input
                    EditText entree2 = (EditText) findViewById(R.id.editText);

                    // Creates result2 to place the output
                    TextView result2 = (TextView) findViewById(R.id.textView);

                    try {
                        // Takes the input as a double
                        double entree = Double.parseDouble(entree2.getText().toString());

                        // Sends the input to intoF function
                        double result = intoF(entree);

                        // Places the value from the result (output from intoF function) in the output string
                        String output = Double.toString(result);

                        // Shows the conversion
                        result2.setText("Temperature " + entree + " (C) is " + output + " (F)");
                    }
                    catch (NumberFormatException nfe) {
                        result2.setText("Invalid numerical input");
                    }
                    catch (Exception e) {
                        result2.setText("Unspecified exception, but not NFE");
                    }

                    // Removes the user input from the entree2
                    entree2.setText(null);
                }
            }
            );
        }

        if (position == 2) {
            // Sets the button to the appropriate text in the Headline
            show = (Button) findViewById(R.id.button);

            // Makes the buttons invisible
            toF.setVisibility(View.INVISIBLE);
            toC.setVisibility(View.INVISIBLE);

            // Makes the texts invisible
            EditText remove1 = (EditText) findViewById(R.id.editText);
            remove1.setVisibility(View.INVISIBLE);
            TextView remove2= (TextView) findViewById(R.id.textView);
            remove2.setVisibility(View.INVISIBLE);
        }

        // Capture the article fragment from the activity layout
        ArticleFragment articleFrag = (ArticleFragment)
                getSupportFragmentManager().findFragmentById(R.id.article_fragment);

            // Call a method in the ArticleFragment to update its content
            articleFrag.updateArticleView(position);

    }
}