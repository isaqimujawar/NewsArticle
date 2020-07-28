package com.codingapps.newsarticle.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingapps.newsarticle.R
import com.codingapps.newsarticle.adapter.FactAdapter
import com.codingapps.newsarticle.util.TopSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    //vars
    private val TAG = "MainFragment"
    private lateinit var factAdapter: FactAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }
    private fun setupRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
            factAdapter = FactAdapter()
            adapter = factAdapter

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}