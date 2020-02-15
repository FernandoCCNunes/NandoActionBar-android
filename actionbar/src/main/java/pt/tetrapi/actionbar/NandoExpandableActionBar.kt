package pt.tetrapi.actionbar

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.children
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.nando_expandable_actionbar.view.*


class NandoExpandableActionBar: ConstraintLayout {

    var title: String? = null
    var titleEnabled: Boolean = true
    var collapsedTitleGravity: Int? = null
    var expandedTitleGravity: Int? = null
    var toolbarHeight: Int? = null
    var toolbarExpandedHeight: Int? = null
    var navigationIcon: Int? = null

    constructor(context: Context) : super(context) {
        inflateLayout()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context) {
        setupAttributes(attrs)
        inflateLayout()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context) {
        setupAttributes(attrs, defStyleAttr)
        inflateLayout()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context) {
        setupAttributes(attrs, defStyleAttr, defStyleRes)
        inflateLayout()

    }

    private fun inflateLayout() {
        inflate(context, R.layout.nando_expandable_actionbar, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        Log.d("Log", "Title 1-> $title")
        collapsing_toolbar_layout_nando_expandable_actionbar.isTitleEnabled = titleEnabled
        material_toolbar_nando_expandable_actionbar.title = title

        if (collapsedTitleGravity != null) {
            collapsing_toolbar_layout_nando_expandable_actionbar.collapsedTitleGravity = collapsedTitleGravity!!
        }

        if (expandedTitleGravity != null) {
            collapsing_toolbar_layout_nando_expandable_actionbar.expandedTitleGravity = expandedTitleGravity!!
        }

        if (toolbarHeight != null) {
            val layoutParams = CollapsingToolbarLayout.LayoutParams(LayoutParams.MATCH_PARENT, toolbarHeight!!)
            layoutParams.collapseMode = CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN
            material_toolbar_nando_expandable_actionbar.layoutParams = layoutParams
        }

        if (toolbarExpandedHeight != null) {
            val layoutParams = CoordinatorLayout.LayoutParams(LayoutParams.MATCH_PARENT, toolbarExpandedHeight!!)
            appbar_layout_nando_expandable_actionbar.layoutParams = layoutParams
        }

        if (navigationIcon != null) {
            material_toolbar_nando_expandable_actionbar.setNavigationIcon(navigationIcon!!)
        }

        for ((index, child) in children.withIndex()) {
            if (index != 0) {
                removeViewAt(index)
                linear_layout_nando_expandable_actionbar_content.addView(child)
            }
        }
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.NandoExpandableActionBar, 0, 0)
        getAttributes(typedArray)
        typedArray.recycle()
    }

    private fun setupAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.NandoExpandableActionBar, defStyleAttr, 0)
        getAttributes(typedArray)
        typedArray.recycle()
    }

    private fun setupAttributes(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.NandoExpandableActionBar, defStyleAttr, defStyleRes)
        getAttributes(typedArray)
        typedArray.recycle()
    }

    private fun getAttributes(typedArray: TypedArray) {
        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_title)) {
            title = typedArray.getString(R.styleable.NandoExpandableActionBar_title)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_titleEnabled)) {
            titleEnabled = typedArray.getBoolean(R.styleable.NandoExpandableActionBar_titleEnabled, true)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_collapsedTitleGravity)) {
            collapsedTitleGravity = typedArray.getInteger(R.styleable.NandoExpandableActionBar_collapsedTitleGravity, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_expandedTitleGravity)) {
            expandedTitleGravity = typedArray.getInteger(R.styleable.NandoExpandableActionBar_expandedTitleGravity, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_toolbarHeight)) {
            toolbarHeight = typedArray.getDimension(R.styleable.NandoExpandableActionBar_toolbarHeight, 0f).toInt()
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_expandedToolbarHeight)) {
            toolbarExpandedHeight = typedArray.getDimension(R.styleable.NandoExpandableActionBar_expandedToolbarHeight, 0f).toInt()
        } else {
            throw RuntimeException("'expandedToolbarHeight' attribute should be defined")
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_toolbarHeight)) {
            toolbarHeight = typedArray.getDimension(R.styleable.NandoExpandableActionBar_toolbarHeight, 0f).toInt()
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_navigationIcon)) {
            navigationIcon = typedArray.getResourceId(R.styleable.NandoExpandableActionBar_navigationIcon, -0)
        }
    }
}