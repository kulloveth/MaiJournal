package com.example.maijournal.ui.category


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.maijournal.R
import com.example.maijournal.data.model.CategoryX


class CategoryAdapter( mcontext: Context,
    val categories: List<CategoryX>)
    : ArrayAdapter<CategoryX>(mcontext, 0, categories) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var dropdownItemView = convertView

        if (dropdownItemView == null)
            dropdownItemView = LayoutInflater.from(context)
                .inflate(R.layout.item_layout, parent,false)

        val category = categories[position]

        val flagImage: ImageView = dropdownItemView!!.findViewById(R.id.categoryIv)
        val res = context.resources.getIdentifier(category.icon,"drawable",context.packageName)
        Log.d("im", "getView: $res")
        flagImage.setImageResource(res)

        val langTextView: TextView = dropdownItemView.findViewById(R.id.categoryTv)
        langTextView.text = category.name

        return dropdownItemView
    }


}