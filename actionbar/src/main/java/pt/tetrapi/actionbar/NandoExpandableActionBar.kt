package pt.tetrapi.actionbar

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.annotation.Dimension
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.res.getBooleanOrThrow
import androidx.core.view.children
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.nando_expandable_actionbar.view.*


class NandoExpandableActionBar: ConstraintLayout {

    var title: String? = null
    var titleEnabled: Boolean = true
    var titleTextColor: Int? = null
    var titleCollapsedTextColor: Int? = null
    var titleExpandedTextColor: Int? = null
    var titleTextAppearance: Int? = null
    var collapsedTitleGravity: Int? = null
    var expandedTitleGravity: Int? = null
    var subtitle: String? = null
    var subtitleTextColor: Int? = null
    var subtitleTextAppearance: Int? = null
    var toolbarHeight: Int? = null
    var toolbarExpandedHeight: Int? = null
    var navigationIcon: Int? = null
    var navigationIconContent: Int? = null
    var logo: Int? = null
    var menu: Int? = null
    var contentScrim: Int? = null
    var scrimAnimationDuration: Int? = null
    var scrimVisibleHeightTrigger: Int? = null
    var toolbarBackground: Int? = null
    var toolbarBackgroundColor: Int? = null
    var extendedToolbarBackground: Int? = null
    var extendedToolbarBackgroundColor: Int? = null

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

        collapsing_toolbar_layout_nando_expandable_actionbar.isTitleEnabled = titleEnabled

        if (title != null) {
            material_toolbar_nando_expandable_actionbar.title = title
        }

        if (titleTextColor != null) {
            material_toolbar_nando_expandable_actionbar.setTitleTextColor(titleTextColor!!)
        }

        if (titleCollapsedTextColor != null) {
            collapsing_toolbar_layout_nando_expandable_actionbar.setCollapsedTitleTextColor(titleCollapsedTextColor!!)
        }

        if (titleExpandedTextColor != null) {
            collapsing_toolbar_layout_nando_expandable_actionbar.setExpandedTitleColor(titleExpandedTextColor!!)
        }

        if (titleTextAppearance != null) {
            material_toolbar_nando_expandable_actionbar.setTitleTextAppearance(context, titleTextAppearance!!)
        }

        if (subtitle != null) {
            material_toolbar_nando_expandable_actionbar.subtitle = subtitle
        }

        if (subtitleTextColor != null) {
            material_toolbar_nando_expandable_actionbar.setSubtitleTextColor(subtitleTextColor!!)
        }

        if (subtitleTextAppearance != null) {
            material_toolbar_nando_expandable_actionbar.setSubtitleTextAppearance(context, subtitleTextAppearance!!)
        }

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

        if (navigationIconContent != null) {
            material_toolbar_nando_expandable_actionbar.setNavigationContentDescription(navigationIconContent!!)
        }

        if (logo != null) {
            material_toolbar_nando_expandable_actionbar.setLogo(logo!!)
        }

        if (menu != null) {
            material_toolbar_nando_expandable_actionbar.inflateMenu(menu!!)
        }

        if (contentScrim != null) {
            collapsing_toolbar_layout_nando_expandable_actionbar.setContentScrimColor(contentScrim!!)
        }

        if (scrimAnimationDuration != null) {
            collapsing_toolbar_layout_nando_expandable_actionbar.scrimAnimationDuration = scrimAnimationDuration!!.toLong()
        }

        if (scrimVisibleHeightTrigger != null) {
            collapsing_toolbar_layout_nando_expandable_actionbar.scrimVisibleHeightTrigger = scrimVisibleHeightTrigger!!
        }

        if (toolbarBackground != null) {
            material_toolbar_nando_expandable_actionbar.setBackgroundResource(toolbarBackground!!)
        }

        if (toolbarBackgroundColor != null) {
            material_toolbar_nando_expandable_actionbar.setBackgroundColor(toolbarBackgroundColor!!)
        }

        if (extendedToolbarBackground != null) {
            collapsing_toolbar_layout_nando_expandable_actionbar.setBackgroundResource(extendedToolbarBackground!!)
        }

        if (extendedToolbarBackgroundColor != null) {
            material_toolbar_nando_expandable_actionbar.setBackgroundColor(extendedToolbarBackgroundColor!!)
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

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_titleTextColor)) {
            titleTextColor = typedArray.getColor(R.styleable.NandoExpandableActionBar_titleTextColor, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_titleCollapsedTextColor)) {
            titleCollapsedTextColor = typedArray.getColor(R.styleable.NandoExpandableActionBar_titleCollapsedTextColor, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_titleExpandedTextColor)) {
            titleExpandedTextColor = typedArray.getColor(R.styleable.NandoExpandableActionBar_titleExpandedTextColor, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_collapsedTitleGravity)) {
            collapsedTitleGravity = typedArray.getInteger(R.styleable.NandoExpandableActionBar_collapsedTitleGravity, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_expandedTitleGravity)) {
            expandedTitleGravity = typedArray.getInteger(R.styleable.NandoExpandableActionBar_expandedTitleGravity, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_subtitle)) {
            subtitle = typedArray.getString(R.styleable.NandoExpandableActionBar_subtitle)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_subtitleTextColor)) {
            subtitleTextColor = typedArray.getInteger(R.styleable.NandoExpandableActionBar_subtitleTextColor, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_subtitleTextAppearance)) {
            subtitleTextAppearance = typedArray.getInteger(R.styleable.NandoExpandableActionBar_subtitleTextAppearance, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_toolbarHeight)) {
            toolbarHeight = typedArray.getDimension(R.styleable.NandoExpandableActionBar_toolbarHeight, 0f).toInt()
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_expandedToolbarHeight)) {
            toolbarExpandedHeight = typedArray.getDimension(R.styleable.NandoExpandableActionBar_expandedToolbarHeight, 0f).toInt()
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_toolbarHeight)) {
            toolbarHeight = typedArray.getDimension(R.styleable.NandoExpandableActionBar_toolbarHeight, 0f).toInt()
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_navigationIcon)) {
            navigationIcon = typedArray.getResourceId(R.styleable.NandoExpandableActionBar_navigationIcon, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_navigationIconContent)) {
            navigationIconContent = typedArray.getResourceId(R.styleable.NandoExpandableActionBar_navigationIconContent, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_logo)) {
            logo = typedArray.getResourceId(R.styleable.NandoExpandableActionBar_logo, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_menu)) {
            menu = typedArray.getResourceId(R.styleable.NandoExpandableActionBar_menu, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_contentScrim)) {
            contentScrim = typedArray.getColor(R.styleable.NandoExpandableActionBar_contentScrim, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_scrimAnimationDuration)) {
            scrimAnimationDuration = typedArray.getColor(R.styleable.NandoExpandableActionBar_scrimAnimationDuration, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_scrimVisibleHeightTrigger)) {
            scrimVisibleHeightTrigger = typedArray.getDimension(R.styleable.NandoExpandableActionBar_scrimVisibleHeightTrigger, 0f).toInt()
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_toolbarBackground)) {
            toolbarBackground = typedArray.getResourceId(R.styleable.NandoExpandableActionBar_toolbarBackground, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_toolbarBackgroundColor)) {
            toolbarBackgroundColor = typedArray.getColor(R.styleable.NandoExpandableActionBar_toolbarBackgroundColor, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_extendedToolbarBackground)) {
            extendedToolbarBackground = typedArray.getResourceId(R.styleable.NandoExpandableActionBar_extendedToolbarBackground, 0)
        }

        if (typedArray.hasValue(R.styleable.NandoExpandableActionBar_extendedToolbarBackgroundColor)) {
            extendedToolbarBackgroundColor = typedArray.getColor(R.styleable.NandoExpandableActionBar_extendedToolbarBackgroundColor, 0)
        }
    }
}