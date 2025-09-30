/**
 * Brigitte Smith
 * Lab 3 - Ticketing App
 * On launch opens a single page calculator to determine the cost of multiple types and amounts of tickets for sale.
 * 09/27/2025
 */

package com.example.lab3_bsmith179_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
double costPerTicket;
int numberOfTickets;
double totalCost;
String ticketChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Added user input options
        final EditText tickets = (EditText)findViewById(R.id.tvTickets);
        final Spinner type = (Spinner)findViewById(R.id.spTicketType);
        final TextView result = ((TextView)findViewById(R.id.tvResult));
        Button cost = (Button)findViewById(R.id.btCost);

        cost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                numberOfTickets = Integer.parseInt(tickets.getText( ).toString());
                ticketChoice = type.getSelectedItem().toString();

                if (ticketChoice.equals("Adult")) {
                    costPerTicket = 15.99;
                } else if (ticketChoice.equals("Child")) {
                    costPerTicket = 8.50;
                } else if (ticketChoice.equals("Senior")) {
                    costPerTicket = 12.0;
                } else {
                    costPerTicket = 0.00;
                }

                totalCost = costPerTicket * numberOfTickets;

                DecimalFormat currency = new DecimalFormat("$###,###.00");
                result.setText(numberOfTickets + " " + ticketChoice + " ticket(s): " + currency.format(totalCost));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}