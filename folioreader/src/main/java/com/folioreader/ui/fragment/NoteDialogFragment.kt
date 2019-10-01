package com.folioreader.ui.fragment

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import android.graphics.drawable.InsetDrawable
import android.R



/**
 * FolioReader-Android
 * Copyright © 2019 PT. MetraPlasa.
 *
 * Created by asadurrahman.qayyim on 10/1/2019
 */
class NoteDialogFragment : DialogFragment() {

    private var content: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        content = arguments?.getString("content")

        // Pick a style based on the num.
        val style = DialogFragment.STYLE_NO_FRAME
        val theme = com.folioreader.R.style.DialogTheme

        setStyle(DialogFragment.STYLE_NO_TITLE, 0)
    }

    override fun onStart() {
        super.onStart()
        val d = dialog
        if (d != null) {
            d.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            //dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val back = ColorDrawable(Color.TRANSPARENT)
            val inset = InsetDrawable(back, 20)
            dialog.window.setBackgroundDrawable(inset)

        }
    }

    override fun onActivityCreated(arg0: Bundle?) {
        super.onActivityCreated(arg0)
        dialog.window!!.attributes.windowAnimations = com.folioreader.R.style.DialogAnimation
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(com.folioreader.R.layout.note_dialog_fragment, container, false)

        /*val btnCancel = view.findViewById<View>(R.id.buttonCancel) as Button
        val btnAccept = view.findViewById<View>(R.id.buttonAccept) as ImageButton

        val textViewContent = view.findViewById<View>(R.id.textViewContent) as TextView
        textViewContent.text = content

        btnCancel.setOnClickListener {
            Toast.makeText(activity, "action cancelled", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        btnAccept.setOnClickListener {
            Toast.makeText(activity, "User Accepted Action", Toast.LENGTH_SHORT).show()
            dismiss()
        }*/

        return view
    }

}


