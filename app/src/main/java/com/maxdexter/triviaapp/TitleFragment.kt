package com.maxdexter.triviaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.maxdexter.triviaapp.databinding.FragmentTitleBinding

class TitleFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        return binding.root
    }
}