package com.example.testservicesdev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: CatalogViewModel



    override fun onCreate(savedInstanceState: Bundle?) {

      /*val triggerTime:LocalDateTime =LocalDateTime.ofInstant(
    Instant.ofEpochSecond(1556916483),  ZoneOffset.UTC)
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss")
        var answer: String =  triggerTime.format(formatter)
  */

        Stetho.initializeWithDefaults(this);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(CatalogViewModel::class.java)

      /*  viewModel.allCity.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { println(it) }
        })
*/

        buttonu.setOnClickListener {
            viewModel.insert(Catalog(90,"Barranquilla","534635332"))

        }
    }

}
