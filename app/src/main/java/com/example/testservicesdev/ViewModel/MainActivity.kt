package com.example.testservicesdev.ViewModel

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.testservicesdev.Service.CityApiService
import com.example.testservicesdev.R
import com.facebook.stetho.Stetho
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: CatalogViewModel
    val cityApiServe by lazy {
        CityApiService.create()
    }
    var disposable: Disposable? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        /*val triggerTime:LocalDateTime =LocalDateTime.ofInstant(
      Instant.ofEpochSecond(1556916483),  ZoneOffset.UTC)
          val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss")
          var answer: String =  triggerTime.format(formatter)
    */

        Stetho.initializeWithDefaults(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProviders.of(this).get(CatalogViewModel::class.java)

        viewModel.allCity.observe(this, Observer { words ->
              // Update the cached copy of the words in the adapter.
              words?.let {
                  if (it.isEmpty()) {
                      if (getConnection(this)) {
                          getService(null)
                      }
                  }else{
                      viewModel.lastDate= it.last().dateCity
                  }
              }
          })

        buttonu.setOnClickListener {

            if (getConnection(this)){
                buttonu.isClickable = false
                buttonu.text = "Nooo"

                getService(viewModel.lastDate)
            }

        }
    }

    private fun getService(LastDate: String?) {
        Toast.makeText(this,LastDate,Toast.LENGTH_LONG).show()
        disposable =
            cityApiServe.hitCountCheck()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        viewModel.inserts(result.cities)
                        buttonu.isClickable = true
                        buttonu.text = "Action"
                    },
                    { error ->
                        labelprincipal.text = (error.message)
                        buttonu.isClickable = true
                        buttonu.text = "Action"
                    }
                )
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }
    private fun getConnection(cont:Context):Boolean{

            val cm = cont.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo: NetworkInfo? =cm.activeNetworkInfo
        return if (activeNetworkInfo != null) {
            activeNetworkInfo.isConnected
        }else{
            Toast.makeText(cont,"No hay Internet!! O.O",Toast.LENGTH_LONG).show()
            false
        }

    }

}
