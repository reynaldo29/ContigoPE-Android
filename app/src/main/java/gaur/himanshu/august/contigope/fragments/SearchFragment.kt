package gaur.himanshu.august.contigope.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gaur.himanshu.august.contigope.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    var quotesList = ArrayList<DataVenta>()
    lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getQuote()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view:View = inflater.inflate(R.layout.fragment_search2, container, false)
        rv = view.findViewById(R.id.recyclerView4)
        return view

    }


    private fun getQuote(){
        val client = APIClient().getRetrofitVentas().create(ApiInterface::class.java)
        client.getVentas().enqueue(object : Callback<List<DataVenta>> {
            override fun onResponse(
                call: Call<List<DataVenta>>,
                response: Response<List<DataVenta>>
            ) {
                // Used for inserting data in arraylist of type DataModel
                quotesList = response.body() as ArrayList<DataVenta>
                val adapter = VentaAdapter(quotesList)

                // For showing data list vertically

                rv.layoutManager = LinearLayoutManager(context)
                rv.adapter = adapter
            }

            override fun onFailure(call: Call<List<DataVenta>>, t: Throwable) {
                // Write a code for failure
            }

        })
    }

}