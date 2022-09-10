package com.fajar.wordapp.letter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.fajar.wordapp.R

class AdapterLetter :
    RecyclerView.Adapter<AdapterLetter.LetterViewHolder>() {

    private val list = ('A').rangeTo('Z').toList()

    class LetterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById(R.id.btn_item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_row_list, parent, false)

        return LetterViewHolder(layout)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = list.get(position)
        holder.button.text = item.toString()


        holder.button.setOnClickListener {
            val action = FragmentLetterDirections.actionLetterListFragmentToWordListFragment(
                holder.button.text.toString()
            )
            // Navigate using that action
            holder.view.findNavController().navigate(action)
        }

    }
}