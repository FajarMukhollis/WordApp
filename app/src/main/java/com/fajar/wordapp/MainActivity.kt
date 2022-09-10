package com.fajar.wordapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.fajar.wordapp.databinding.ActivityMainBinding
import com.fajar.wordapp.letter.AdapterLetter
import com.fajar.wordapp.letter.FragmentLetter
import com.fajar.wordapp.word.FragmentWord

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        addFragment(FragmentLetter())
    }

    fun replaceFragment(fragment: Fragment, data: String) {
        val bundle = Bundle()
        bundle.putString(FragmentWord.LETTER, data)
        fragment.arguments = bundle
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container,fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun addFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container,fragment)
        fragmentTransaction.commit()
    }

}