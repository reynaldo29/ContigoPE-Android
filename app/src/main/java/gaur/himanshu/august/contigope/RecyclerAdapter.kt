package gaur.himanshu.august.contigope

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class RecyclerAdapter(private val dataList: List<DataModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recyclerModel = dataList[position]

        // Text set to the TextView widget
        holder.precio.text = "$"+recyclerModel.precio.toString()
        holder.nombre.text = recyclerModel.nombre
        holder.stock.text = recyclerModel.stock.toString()
        holder.marca.text = recyclerModel.marca


        Glide
            .with(holder.imagenProd.context)
            .load(recyclerModel.img_delante)
            .into(holder.imagenProd)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imagenProd: ImageView = itemView.findViewById(R.id.imagenProd)
        val precio: TextView = itemView.findViewById(R.id.precio)
        val nombre:TextView = itemView.findViewById(R.id.nombre)
        val stock: TextView = itemView.findViewById(R.id.stock)
        val marca: TextView = itemView.findViewById(R.id.marca)
    }

}