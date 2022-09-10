package com.fajar.wordapp.letter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fajar.wordapp.MainActivity
import com.fajar.wordapp.data.Data
import com.fajar.wordapp.databinding.ItemRowListBinding
import com.fajar.wordapp.word.FragmentWord

class AdapterLetter(private var listLetter: ArrayList<Data>) :
    RecyclerView.Adapter<AdapterLetter.LetterViewHolder>() {

    class LetterViewHolder(val view: ItemRowListBinding) : RecyclerView.ViewHolder(view.root) {
//        val btnLetter: Button = itemView.findViewById(R.id.btn_item)
    }

    override fun getItemCount(): Int {
        return listLetter.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = ItemRowListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LetterViewHolder(layout)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = listLetter[position].data

        with(holder){
            view.btnItem.text = item

            view.btnItem.setOnClickListener{
                val action = (itemView.context as MainActivity)
                action.replaceFragment(FragmentWord(), item)
            }
        }
    }
}