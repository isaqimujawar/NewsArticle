package com.codingapps.newsarticle.ui

import androidx.appcompat.app.AlertDialog
import com.codingapps.newsarticle.R

fun MainFragment.showAlertDialog() {
    val builder: AlertDialog.Builder? = activity?.let {
        AlertDialog.Builder(it)
    }
    builder?.setMessage(R.string.dialog_message)
        ?.setTitle(R.string.dialog_title)
        ?.setIcon(android.R.drawable.ic_dialog_alert)?.show()
    val dialog: AlertDialog? = builder?.create()
}

