package com.jamadev.mealfinder.base

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


open class BaseFragment: Fragment() {

    protected fun showBackButton(showBackButton: Boolean) {
        if ( (activity as AppCompatActivity)?.supportActionBar != null) {
            (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(
                showBackButton
            )
        }
    }

    protected fun hideKeyboard() {
        if(activity != null) {
            val imm: InputMethodManager =
                activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            //Find the currently focused view, so we can grab the correct window token from it.
            var view: View? = activity?.currentFocus
            //If no view currently has focus, create a new one, just so we can grab a window token from it
            if (view == null) {
                view = View(activity)
            }
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}