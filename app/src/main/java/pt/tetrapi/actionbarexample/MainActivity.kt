package pt.tetrapi.actionbarexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_testing2.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayOfNames: ArrayList<String> = arrayListOf(
            "Fernando",
            "Francisco",
            "Joana",
            "Mama",
            "Papa",
            "Filipe",
            "Alexandra",
            "Frederico",
            "Neuza",
            "Rita",
            "Vitor",
            "André",
            "Gabriela",
            "Pilar",
            "GueGue"
        )
        val adapter = TestingAdapter(this, arrayOfNames)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //my_recycler_view.layoutManager = layoutManager
        //my_recycler_view.adapter = adapter
    }

    class TestingAdapter(private val context: Context, var items: ArrayList<String>): RecyclerView.Adapter<TestingAdapter.ViewHolder>() {

        class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val card: CardView = view.findViewById(R.id.card)
            val name: TextView = view.findViewById(R.id.card_name)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return ViewHolder(inflater.inflate(R.layout.card, parent, false))
        }

        override fun getItemCount(): Int = items.size

        /*
        * To NOTE!
        *
        * To remove items by their position you should use holder.getAdapterPosition()[JAVA] or holder.adapterPosition [Kotlin]
        * the reason being that the recycler view does not REDRAW views after using any notify with the exception of
        * notifyDataSetChanged, only in this case does the recycler view completely redraws every child and provides the correct
        * position in the onBindViewHolder function
        */
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]

            holder.name.text = item

            holder.card.setOnClickListener {

            }
        }
    }
}
