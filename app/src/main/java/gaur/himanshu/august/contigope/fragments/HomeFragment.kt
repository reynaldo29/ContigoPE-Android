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

class HomeFragment : Fragment() {

    var quotesList = ArrayList<DataModel>()
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
        var view:View = inflater.inflate(R.layout.activity_main2, container, false)
        rv = view.findViewById(R.id.recyclerView);
        return view

    }


    private fun getQuote(){
        val client = APIClient().getRetrofitClient().create(ApiInterface::class.java)
        client.getQuotes().enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            ) {
                // Used for inserting data in arraylist of type DataModel
                quotesList = response.body() as ArrayList<DataModel>
                val adapter = RecyclerAdapter(quotesList)

                // For showing data list vertically

                rv.layoutManager = LinearLayoutManager(context)
                rv.adapter = adapter
            }
            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                // Write a code for failure
            }

        })
    }

}