package com.folioreader.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.folioreader.Config
import com.folioreader.R
import com.folioreader.model.event.GotoPageEvent
import com.folioreader.ui.activity.FolioActivity
import com.folioreader.ui.activity.FolioActivityCallback
import com.folioreader.util.AppUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.warkiz.widget.IndicatorSeekBar
import com.warkiz.widget.OnSeekChangeListener
import com.warkiz.widget.SeekParams
import com.xw.repo.BubbleSeekBar
import kotlinx.android.synthetic.main.view_config_page.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by mobisys2 on 11/16/2016.
 */
class ConfigPageBottomSheetDialogFragment : BottomSheetDialogFragment(), OnSeekChangeListener {

    private var progressPageValue = 0
    fun setProgressPage(page : Int){
        progressPageValue = page
    }
    override fun onSeeking(seekParams: SeekParams?) {
        seekParams?.let{
            progressPageValue = it.progress
            tvCountPage.setText(progressPageValue.toString())
        }
    }

    override fun onStartTrackingTouch(seekBar: IndicatorSeekBar?) {
        //do nothing
    }

    override fun onStopTrackingTouch(seekBar: IndicatorSeekBar?) {
        val page = GotoPageEvent()
        page.page = progressPageValue
        EventBus.getDefault().post(page)
    }

    companion object {
        @JvmField
        val LOG_TAG: String = ConfigPageBottomSheetDialogFragment::class.java.simpleName
    }

    private lateinit var config: Config
    private lateinit var activityCallback: FolioActivityCallback

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.view_config_page, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity is FolioActivity)
            activityCallback = activity as FolioActivity

        config = AppUtil.getSavedConfig(activity)!!
        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        view?.viewTreeObserver?.addOnGlobalLayoutListener(null)
    }

    private fun initViews() {
        configSeekBar()
    }

    private fun configSeekBar() {
        tvCountPage.setText(progressPageValue.toString())
        seekBar.onSeekChangeListener = this
        seekBar.setProgress(progressPageValue.toFloat())
   }

}
