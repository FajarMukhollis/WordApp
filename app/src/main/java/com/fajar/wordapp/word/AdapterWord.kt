package com.fajar.wordapp.word

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.fajar.wordapp.R

class AdapterWord(private val letterId: String, context: Context) :
    RecyclerView.Adapter<AdapterWord.WordViewHolder>() {

    private val filterWord: List<String>

    init {
        val words = context.resources.getStringArray(R.array.words).toList()

        filterWord = words
            .filter { it.startsWith(letterId, ignoreCase = true) }
            .shuffled()
            .take(5)
            .sorted()
    }

    class WordViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val btnWord = view.findViewById<Button>(R.id.btn_item)
    }

    override fun getItemCount(): Int {
        return filterWord.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_row_list, parent, false)

        return WordViewHolder(layout)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val item = filterWord[position]
        val context = holder.view.context

        holder.btnWord.text = item

        holder.btnWord.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${FragmentWord.SEARCH_PREFIX}${item}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }
    }
}

