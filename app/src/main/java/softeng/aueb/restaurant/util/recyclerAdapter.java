package softeng.aueb.restaurant.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import softeng.aueb.restaurant.R;
import softeng.aueb.restaurant.domain.Order;
import softeng.aueb.restaurant.domain.ProductItem;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder>{

    private ArrayList<ProductItem> menu;

    public recyclerAdapter(ArrayList<ProductItem> items){
        menu = items;
    }


    protected class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView nameTxt;
        private TextView priceTxt;

        public ViewHolder(final View view){
            super(view);
            nameTxt = view.findViewById(R.id.menuitem);
            priceTxt = view.findViewById(R.id.itemprice);
        }
    }
    /**
     * Called when RecyclerView needs a new {@link recyclerAdapterOrder.ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     */
    @NotNull
    @Override
    public recyclerAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new ViewHolder(itemView);
    }
    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link recyclerAdapterOrder.ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link recyclerAdapterOrder.ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * handle efficient partial bind.
     */
    @Override
    public void onBindViewHolder(@NonNull @NotNull recyclerAdapter.ViewHolder holder, int position) {
        String name = menu.get(position).getName();
        String price = Double.toString(menu.get(position).getCost());
        holder.nameTxt.setText(name);
        holder.priceTxt.setText(price);
    }
    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return menu.size();
    }
}
