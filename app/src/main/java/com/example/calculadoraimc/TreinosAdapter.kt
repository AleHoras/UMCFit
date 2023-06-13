import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calculadoraimc.R
import com.example.calculadoraimc.Treino

class TreinosAdapter : RecyclerView.Adapter<TreinosAdapter.TreinoViewHolder>() {

    private val treinos: MutableList<Treino> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreinoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_treino, parent, false)
        return TreinoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TreinoViewHolder, position: Int) {
        val treino = treinos[position]
        holder.bind(treino)
    }

    override fun getItemCount(): Int {
        return treinos.size
    }

    fun setTreinos(treinos: List<Treino>) {
        this.treinos.clear()
        this.treinos.addAll(treinos)
        notifyDataSetChanged()
    }

    inner class TreinoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewTipo: TextView = itemView.findViewById(R.id.textViewTipo)
        private val textViewDataHora: TextView = itemView.findViewById(R.id.textViewDataHora)

        fun bind(treino: Treino) {
            textViewTipo.text = treino.tipo
            textViewDataHora.text = treino.dataHora
        }
    }
}
