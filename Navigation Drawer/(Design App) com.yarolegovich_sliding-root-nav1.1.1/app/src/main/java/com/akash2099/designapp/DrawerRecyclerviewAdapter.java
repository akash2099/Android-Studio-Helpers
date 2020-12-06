package com.akash2099.designapp;
//ignore
//
//import android.util.SparseArray;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class DrawerRecyclerviewAdapter extends RecyclerView.Adapter<DrawerRecyclerviewAdapter.ViewHolder> {
//
//    private List<DrawerRecyclerviewItems> items;
//    private Map<Class<?extends DrawerRecyclerviewItems>,Integer> viewTypes;
//    private SparseArray<DrawerRecyclerviewItems> holderFactories;
//
//    private AdapterView.OnItemClickListener listener;
//
//    public DrawerRecyclerviewAdapter(List<DrawerRecyclerviewItems> items){
//        this.items=items;
//        this.viewTypes=new HashMap<>();
//        this.holderFactories=new SparseArray<>();
//        processViewTypes();
//    }
//
//    private void processViewTypes(){
//        int type=0;
//        for (DrawerRecyclerviewItems item:items){
//            if(!viewTypes.containsKey(item.getClass())){
//                viewTypes.put(item.getClass(),type);
//                holderFactories.put(type,item);
//                type++;
//            }
//        }
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        ViewHolder holder=holderFactories.get(viewType).createViewHolder(parent);
//        holder.drawerRecyclerviewAdapter=this;
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        items.get(position).bindViewHolder(holder);
//    }
//
//    @Override
//    public int getItemCount() {
//        return items.size();
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return viewTypes.get(items.get(position).getClass());
//    }
//
//    public void setSelected(int position){
//        DrawerRecyclerviewItems newChecked=items.get(position);
//        if(!newChecked.isSelectable()){
//            return;
//        }
//
//        for(int i=0;i<items.size();i++){
//            DrawerRecyclerviewItems item=items.get(i);
//            if(item.isChecked()){
//                item.setChecked(false);
//                notifyItemChanged(i);
//                break;
//            }
//
//        }
//
//        newChecked.setChecked(true);
//        notifyItemChanged(position);
//
//        if(listener!=null){
//            listener.onItemClick();
//        }
//    }
//
//    public void setListener(AdapterView.OnItemClickListener listner){
//        this.listener=listener;
//    }
//
//    public interface onItemSelectedListener{
//        void onItemSelected(int position);
//    }
//
//    //Create inner abstract view holder class which will extend recycler view and implements onclick listner
//    static abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//        private DrawerRecyclerviewAdapter drawerRecyclerviewAdapter;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            itemView.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View v) {
//            drawerRecyclerviewAdapter.setSelected(getAbsoluteAdapterPosition());
//        }
//    }
//}