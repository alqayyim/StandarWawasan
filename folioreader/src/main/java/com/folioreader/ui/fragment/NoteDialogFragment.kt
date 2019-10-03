package com.folioreader.ui.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import android.graphics.drawable.InsetDrawable
import android.util.Log
import android.widget.*
import com.folioreader.R
import com.folioreader.model.HighlightImpl
import com.folioreader.model.event.NoteDataEvent
import kotlinx.android.synthetic.main.note_dialog_fragment.*
import org.greenrobot.eventbus.EventBus


/**
 * FolioReader-Android
 * Copyright © 2019 PT. MetraPlasa.
 *
 * Created by asadurrahman.qayyim on 10/1/2019
 */
class NoteDialogFragment : DialogFragment() {

    private var content: String? = null
    private var highlightStyle: HighlightImpl.HighlightStyle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        content = arguments?.getString("content")

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
        val buttonCancel = view.findViewById<View>(R.id.btnCancel)
        val buttonSave = view.findViewById<View>(R.id.btnSave)
        val buttonYellow = view.findViewById<ImageView>(R.id.yellowHighlight)
        val buttonGreen = view.findViewById<ImageView>(R.id.greenHighlight)
        val buttonBlue = view.findViewById<ImageView>(R.id.blueHighlight)
        val buttonPink = view.findViewById<ImageView>(R.id.pinkHighlight)
        val buttonUnderline = view.findViewById<ImageView>(R.id.underlineHighlight)

        buttonYellow.setOnClickListener {
            highlightStyle = HighlightImpl.HighlightStyle.Yellow
            buttonYellow.setImageResource(R.drawable.selected_highlight_yellow)
            buttonGreen.setImageResource(R.drawable.shape_highlight_green)
            buttonBlue.setImageResource(R.drawable.shape_highlight_blue)
            buttonPink.setImageResource(R.drawable.shape_highlight_pink)
            buttonUnderline.setImageResource(R.drawable.ic_underline_unselected)
        }
        buttonGreen.setOnClickListener {
            highlightStyle = HighlightImpl.HighlightStyle.Green
            buttonYellow.setImageResource(R.drawable.shape_highlight_yellow)
            buttonGreen.setImageResource(R.drawable.selected_highlight_green)
            buttonBlue.setImageResource(R.drawable.shape_highlight_blue)
            buttonPink.setImageResource(R.drawable.shape_highlight_pink)
            buttonUnderline.setImageResource(R.drawable.ic_underline_unselected)
        }
        buttonBlue.setOnClickListener {
            highlightStyle = HighlightImpl.HighlightStyle.Blue
            buttonYellow.setImageResource(R.drawable.shape_highlight_yellow)
            buttonGreen.setImageResource(R.drawable.shape_highlight_green)
            buttonBlue.setImageResource(R.drawable.selected_highlight_blue)
            buttonPink.setImageResource(R.drawable.shape_highlight_pink)
            buttonUnderline.setImageResource(R.drawable.ic_underline_unselected)
        }
        buttonPink.setOnClickListener {
            highlightStyle = HighlightImpl.HighlightStyle.Pink
            buttonYellow.setImageResource(R.drawable.shape_highlight_yellow)
            buttonGreen.setImageResource(R.drawable.shape_highlight_green)
            buttonBlue.setImageResource(R.drawable.shape_highlight_blue)
            buttonPink.setImageResource(R.drawable.selected_highlight_pink)
            buttonUnderline.setImageResource(R.drawable.ic_underline_unselected)
        }
        buttonUnderline.setOnClickListener {
            highlightStyle = HighlightImpl.HighlightStyle.Underline
            buttonYellow.setImageResource(R.drawable.shape_highlight_yellow)
            buttonGreen.setImageResource(R.drawable.shape_highlight_green)
            buttonBlue.setImageResource(R.drawable.shape_highlight_blue)
            buttonPink.setImageResource(R.drawable.shape_highlight_pink)
            buttonUnderline.setImageResource(R.drawable.ic_underline_selected)
        }

        buttonCancel.setOnClickListener {
            dismiss()
        }

        buttonSave.setOnClickListener {
            content = etNotes.text.toString()
            val noteDataEvent = NoteDataEvent()
            noteDataEvent.textNotes = content
            noteDataEvent.pickedHighlightStyle = highlightStyle
            EventBus.getDefault().post(noteDataEvent)
            Toast.makeText(activity, "Note saved!", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        return view
    }

}


