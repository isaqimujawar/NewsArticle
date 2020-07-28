package com.codingapps.newsarticle.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingapps.newsarticle.R
import com.codingapps.newsarticle.adapter.FactAdapter
import com.codingapps.newsarticle.util.TopSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    //vars
    private lateinit var factAdapter: FactAdapter
    private val TAG = "MainFragment"

    //ui
    private lateinit var viewModel: FactViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated: called")
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        Log.d(TAG, "setupViewModel: called")
        viewModel.getfacts()?.observe(viewLifecycleOwner, Observer {
            if (it == null) {
                showAlertDialog2()
            } else {
                it?.rows?.let { it1 -> factAdapter.submitList(it1) }
                //(activity as MainActivity).setActionBarTitle(it.title)
            }
        })
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

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.refresh -> {
                viewModel.loadfacts()
                subscribeObservers()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun MainFragment.showAlertDialog2() {
        val builder: AlertDialog.Builder? = activity?.let {
            AlertDialog.Builder(it)
        }
        builder?.setMessage(R.string.dialog_message)
            ?.setTitle(R.string.dialog_title)
            ?.setIcon(android.R.drawable.ic_dialog_alert)?.show()
        val dialog: AlertDialog? = builder?.create()
    }
}
