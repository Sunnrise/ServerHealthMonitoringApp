package vtys.group.serverhealth.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vtys.group.serverhealth.R
import vtys.group.serverhealth.data.InterruptDataModel

class InterruptsAdapter(private var interruptsList: List<InterruptDataModel>) :
    RecyclerView.Adapter<InterruptsAdapter.InterruptsViewHolder>() {

    class InterruptsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val interruptIdTextView: TextView = itemView.findViewById(R.id.interruptIDTextView)
        val interruptDateTextView: TextView = itemView.findViewById(R.id.interruptDateTextView)
        val interruptTimeTextView: TextView = itemView.findViewById(R.id.interruptTimeTextView)
        val interruptStatusTextView: TextView = itemView.findViewById(R.id.interruptStatusTextView)
        val serverIdTextView: TextView = itemView.findViewById(R.id.serverTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterruptsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_interrupt_detail, parent, false)
        return InterruptsViewHolder(view)
    }

    override fun onBindViewHolder(holder: InterruptsViewHolder, position: Int) {

        val interrupt = interruptsList[position]
        holder.interruptIdTextView.text = interrupt.interruptid.toString()

        // Check for null before setting text
        holder.interruptDateTextView.text = interrupt.interruptdate ?: "N/A"
        holder.interruptTimeTextView.text = interrupt.interrupttime ?: "N/A"

        holder.interruptStatusTextView.text = interrupt.interruptstatus.toString()
        holder.serverIdTextView.text = interrupt.serverid.servername ?: "N/A"

        // Log the values
        Log.d("InterruptAdapter", "Date: ${interrupt.interruptdate}, Time: ${interrupt.interrupttime}")
    }

    override fun getItemCount(): Int {
        return interruptsList.size
    }

    // Use this method to update the dataset
    fun setData(newInterruptsList: List<InterruptDataModel>) {
        interruptsList = newInterruptsList
        notifyDataSetChanged()
    }
}