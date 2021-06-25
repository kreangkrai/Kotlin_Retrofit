package com.example.testretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testretrofit.Interface.INetworkAPI
import com.example.testretrofit.Models.DeviceModel
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var v : List<DeviceModel> = emptyList()
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.movie_list)
        recyclerView!!.layoutManager = LinearLayoutManager(this);
        val url = "https://mee-farm.herokuapp.com/api/v1/"
        try {
            val retrofit = Retrofit.Builder().addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().create()
                )
            )
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url).build()


            val postsApi = retrofit.create(INetworkAPI::class.java)
            val response = postsApi.getAllDevice()


//            var vv = response.subscribeOn(IoScheduler()).observeOn(AndroidSchedulers.mainThread())
//
//            vv.subscribe{res ->
//
//                v = res
//                for (element in v){
//                    Toast.makeText(this,"XXXXXX ${element.device}",Toast.LENGTH_LONG).show()
//                }
//            }

            response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler())
                .subscribe {

                    recyclerView!!.adapter = MovieAdapter(it, this)

                }


        } catch (err: Exception) {
            Toast.makeText(this, err.message, Toast.LENGTH_LONG).show()
        }
    }
}


