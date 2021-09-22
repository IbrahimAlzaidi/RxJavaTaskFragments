package com.example.rxjavataskfragments.ui.fragment


import android.view.LayoutInflater
import com.example.rxjavataskfragments.databinding.FragmentDownBinding
import com.example.rxjavataskfragments.util.Constant

class OutputFragment : BaseFragment<FragmentDownBinding>() {
    private lateinit var dataReceived : String
    override val bindingInflater: (LayoutInflater) -> FragmentDownBinding = FragmentDownBinding::inflate
    override val LOG_TAG = "DownFragment"
    override fun setup() {
        dataReceived = arguments?.getString(Constant.KEY_TAG)?: " "
        binding?.myTextView?.text = dataReceived
    }
}
