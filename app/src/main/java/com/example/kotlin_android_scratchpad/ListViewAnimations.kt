package com.example.kotlin_android_scratchpad

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class ListViewAnimations : AppCompatActivity() {
    val TAG = ListViewAnimations::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_animations)

        val vpaCheckBox = findViewById<CheckBox>(R.id.vpa)
        val transientStateCheckBox = findViewById<CheckBox>(R.id.transientState)

        val listView = findViewById<ListView>(R.id.list)
        val cheeseList = Cheeses.sCheeseStrings.toMutableList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cheeseList)
        listView.adapter = adapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, view, position, _ ->
                if (vpaCheckBox.isChecked) {
                    view.animate().apply {
                        duration = 1000
                        alpha(0f)
                        withEndAction{
                            cheeseList.removeAt(position)
                            adapter.notifyDataSetChanged()
                            view.alpha = 1f
                        }
                    }
                } else {
                    if(transientStateCheckBox.isChecked) {
                        view.setHasTransientState(true)
                    }

                    val anim = ObjectAnimator.ofFloat(view, View.ALPHA, 0f)
                    anim.duration = 10000
                    anim.addListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            cheeseList.removeAt(position)
                            adapter.notifyDataSetChanged()
                            view.alpha = 1f
                        }

                    })
                    anim.start()
                }
            }
    }


}