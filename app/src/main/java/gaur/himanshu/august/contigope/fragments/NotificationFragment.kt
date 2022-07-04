package gaur.himanshu.august.contigope.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import gaur.himanshu.august.contigope.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import gaur.himanshu.august.contigope.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationFragment: Fragment() {

    var quotesList = ArrayList<DataTotal>()
    lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getQuote()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view:View = inflater.inflate(R.layout.activity_main3, container, false)
        rv = view.findViewById(R.id.recyclerView3)
        var editProfileButton: Button = view.findViewById(R.id.btn_pdf)

            editProfileButton.setOnClickListener {
                val editProfileIntent = Intent(activity, firstActivity::class.java)
                startActivity(editProfileIntent)
            }
        return view

    }


    private fun getQuote(){
        val client = APIClient().getRetrofitVentas().create(ApiInterface::class.java)
        client.getTotal().enqueue(object : Callback<List<DataTotal>> {
            override fun onResponse(
                call: Call<List<DataTotal>>,
                response: Response<List<DataTotal>>
            ) {
                // Used for inserting data in arraylist of type DataModel
                quotesList = response.body() as ArrayList<DataTotal>
                val adapter = DashboardAdapter(quotesList)

                // For showing data list vertically

                rv.layoutManager = LinearLayoutManager(context)
                rv.adapter = adapter
            }

            override fun onFailure(call: Call<List<DataTotal>>, t: Throwable) {
                // Write a code for failure
            }

        })
    }

}