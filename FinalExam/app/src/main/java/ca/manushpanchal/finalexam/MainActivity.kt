package ca.manushpanchal.finalexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var spinButton: Button
    private lateinit var selectedDice: Dice
    private lateinit var afterTextView: TextView
    private lateinit var beforeTextView: TextView

    private val dices = arrayOf(
        Dice(4, "Dice 4"),
        Dice(6, "Dice 6"),
        Dice(8, "Dice 8"),
        Dice(10, "Dice 10"),
        Dice(12, "Dice 12"),
        Dice(20, "Dice 20")
    )
    private val diceNames = dices.map { it.name }.toTypedArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //applying spinner
        spinner = findViewById(R.id.spinner)
        spinButton = findViewById(R.id.button)
        afterTextView = findViewById(R.id.textView4)
        beforeTextView = findViewById(R.id.textView3)

        spinButton.setOnClickListener {
            val rollItem = selectedDice.roll()
            if (!afterTextView.text.isNullOrEmpty() && afterTextView.text != "After") {
                beforeTextView.text = afterTextView.text
            }
            afterTextView.text = rollItem.toString()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, diceNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                val choice = adapterView.getItemAtPosition(i).toString()
                selectedDice = dices[i]
                Toast.makeText(applicationContext, choice, Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {}
        }
    }
}
