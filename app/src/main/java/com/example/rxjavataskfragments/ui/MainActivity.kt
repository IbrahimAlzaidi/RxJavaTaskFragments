package com.example.rxjavataskfragments.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjavataskfragments.R
import com.example.rxjavataskfragments.databinding.ActivityMainBinding
import com.example.rxjavataskfragments.ui.fragment.OutputFragment
import com.example.rxjavataskfragments.util.Constant
import com.example.rxjavataskfragments.util.DataConnection

class MainActivity : AppCompatActivity() , DataConnection {

    private lateinit var binding : ActivityMainBinding
    private lateinit var outputFragment : OutputFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun dataTransition(text: String) {
        outputFragment = OutputFragment()
        val bundle = Bundle()
        bundle.putString(Constant.KEY_TAG,text)
        outputFragment.arguments= bundle
        this.supportFragmentManager.beginTransaction().replace(R.id.downFragment, outputFragment).commit()
    }
}
