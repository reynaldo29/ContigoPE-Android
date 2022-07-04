package gaur.himanshu.august.contigope

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.sql.Date
import java.text.DateFormat
import java.text.SimpleDateFormat


class VentaAdapter(private val dataList: List<DataVenta>) : RecyclerView.Adapter<VentaAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ventas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recyclerModel = dataList[position]
        val ahora = System.currentTimeMillis()
        val fecha = Date(ahora)

        val df: DateFormat = SimpleDateFormat("dd/MM/yy")
        val salida: String = df.format(ahora)
        // Text set to the TextView widget
        holder.total.text = "$"+recyclerModel.total.toString()
        holder.cliente.text = recyclerModel.producto
        holder.producto.text = recyclerModel.cliente
        holder.date.text = recyclerModel.fecha
        holder.cantidad.text=recyclerModel.cantidad.toString()



    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val total: TextView = itemView.findViewById(R.id.ventaD)
        val producto:TextView = itemView.findViewById(R.id.producto)
        val cliente :TextView = itemView.findViewById(R.id.cliente)
        val date:TextView = itemView.findViewById(R.id.hora)
        val cantidad: TextView = itemView.findViewById(R.id.cantidad)


    }



}