package com.werder.recyclerviewinsideviewpager

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    private lateinit var disabler: Disabler

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        disabler = context as Disabler
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler.adapter = RVAdapter()

        enable.setOnClickListener {
            disabler.enable()
        }

        disable.setOnClickListener {
            disabler.disable()
        }
    }

    interface Disabler {
        fun disable()
        fun enable()
    }
}

class RVAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = Button(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                400, 500
            )
        }
        return object : RecyclerView.ViewHolder(view) {}
    }

    override fun getItemCount() = 9

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder.itemView as Button).apply {
            text = position.toString()
            setOnClickListener {
                Toast.makeText(context, "position $position", Toast.LENGTH_LONG).show()
            }
        }
    }
}
