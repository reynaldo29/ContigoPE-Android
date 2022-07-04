package gaur.himanshu.august.contigope

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class DashboardAdapter(private val dataList: List<DataTotal>) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dashboard, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recyclerModel = dataList[position]

        // Text set to the TextView widget
        holder.total.text = "$"+recyclerModel.total.toString()
        holder.cliente.text = recyclerModel.igv.toString()
        holder.productos.text = recyclerModel.cantidad.toString()
        holder.producto.text = recyclerModel.producto
        holder.precio.text = recyclerModel.precio.toString()
        holder.cantidad.text = recyclerModel.subtotal.toString()


    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val producto:TextView = itemView.findViewById(R.id.tv_nama_produk)
        val total: TextView = itemView.findViewById(R.id.total_balance)
        val productos: TextView= itemView.findViewById(R.id.fetch)
        val cliente: TextView= itemView.findViewById(R.id.clienteeste)
        val precio : TextView = itemView.findViewById(R.id.tv_preciopro)
        val cantidad: TextView = itemView.findViewById(R.id.cantidad)

    }
}