package com.example.xchangerate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{
    var currency = ""
    var currencyList = arrayOf("Australian Dollar","British Pound","Canadian Dollar",
        "Chinese Yuan Renminbi","Euro","Indian Rupee","Jamaican Dollar","Japanese Yen",
        "Kuwaiti Dinar","Malaysian Ringgit","Singapore Dollar","Swiss Franc")

    var spinner:Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = this.currency_spinner
        spinner!!.setOnItemSelectedListener(this)

        //Create an ArrayAdapter using a simple spinner layout and currency_list array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencyList)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner!!.setAdapter(aa)

    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
        currency = currencyList[position]
    }

    override fun onNothingSelected(arg0: AdapterView<*>?) {

    }

    fun convertCurrency(@Suppress("UNUSED_PARAMETER")view: View){

        if(dollarText.text.isNotEmpty()){
            val dollar = dollarText.text.toString().toFloat()

            val dollarValue = when(currency){
                "Australian Dollar" -> dollar * 1.48f
                "British Pound" -> dollar * 0.77f
                "Canadian Dollar" -> dollar * 1.33f
                "Chinese Yuan Renminbi" -> dollar * 7.03f
                "Euro" -> dollar * 0.9f
                "Indian Rupee" -> dollar * 71.75f
                "Jamaican Dollar" -> dollar * 140.56f
                "Japanese Yen" -> dollar * 109.52f
                "Kuwaiti Dinar" -> dollar * 0.30f
                "Malaysian Ringgit" -> dollar * 4.18f
                "Singapore Dollar" -> dollar * 1.38f
                "Swiss Franc" -> dollar * 1.00f

                else -> dollar
            }

            textView.text = dollarValue.toString()
        } else{
            textView.text = "No Value"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
