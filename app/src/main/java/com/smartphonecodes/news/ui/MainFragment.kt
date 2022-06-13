package com.smartphonecodes.news.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.smartphonecodes.news.R
import com.smartphonecodes.news.data.NewsClickListener
import com.smartphonecodes.news.data.NewsPaperAdapter
import com.smartphonecodes.news.databinding.FragmentMainBinding

class MainFragment : Fragment() {


    private val viewModel: NewsViewModel by activityViewModels()
    private var _binding:FragmentMainBinding? = null
    val binding:FragmentMainBinding = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("Navigation","Listener Calling...")

        binding.newsRecyclerView.adapter = NewsPaperAdapter(NewsClickListener{
            Log.d("Navigation","Listener Calling...")
            Toast.makeText(requireContext(),"I'm Clicked",Toast.LENGTH_SHORT).show()
        })

//        findNavController().navigate(R.id.action_mainFragment_to_fullArticleFragment)

        Log.d("RECYCLERVIEW","Adapter set successful")
    }

//    fun navigateToFull(){
//        findNavController().navigate(R.id.action_mainFragment_to_fullArticleFragment)
//    }


}