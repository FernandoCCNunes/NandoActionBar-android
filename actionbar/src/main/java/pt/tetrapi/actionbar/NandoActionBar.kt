package pt.tetrapi.actionbar

import android.content.Context
import android.util.AttributeSet
import android.view.View

class NandoActionBar: View {

    var title: String? = null
    var opacity: Float? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context) {
        setupAttributes(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context) {
        setupAttributes(attrs, defStyleAttr)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context) {
        setupAttributes(attrs, defStyleAttr, defStyleRes)
    }


    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ActionBar, 0, 0)

        title = typedArray.getString(R.styleable.NandoActionBar_title)

        typedArray.recycle()
    }

    private fun setupAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ActionBar, defStyleAttr, 0)

        title = typedArray.getString(R.styleable.NandoActionBar_title)

        typedArray.recycle()
    }

    private fun setupAttributes(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.NandoActionBar, defStyleAttr, defStyleRes)

        title = typedArray.getString(R.styleable.NandoActionBar_title)
        opacity = typedArray.getDimension(R.styleable.NandoActionBar_opacity, 1.0f)

        typedArray.recycle()
    }

}