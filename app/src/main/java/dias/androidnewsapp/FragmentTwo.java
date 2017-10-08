package dias.androidnewsapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentTwo extends Fragment {

    public FragmentTwo() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(dias.androidnewsapp.R.layout.categories_recycler_view, container, false);

        List<String> list = new ArrayList<>();
        list.add("Policy");
        list.add("Sport");
        list.add("Games");
        list.add("Worldwide");


        int numberOfColumns = 2;
        RecyclerView recyclerView = view.findViewById(dias.androidnewsapp.R.id.categories_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        recyclerView.setAdapter(new RecyclerViewAdapter(list));
        return view;
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private CardView mCardView;
        private TextView mTextView;
        private CircleImageView mImgView;

        public RecyclerViewHolder(View itemView){
            super(itemView);
        }

        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container){
            super(inflater.inflate(dias.androidnewsapp.R.layout.categories_card_view, container, false));

            mCardView = itemView.findViewById(dias.androidnewsapp.R.id.categories_card_container);
            mTextView = itemView.findViewById(dias.androidnewsapp.R.id.text_holder);
            mImgView = itemView.findViewById(dias.androidnewsapp.R.id.img_holder);
        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

        List<String> mList;

        public RecyclerViewAdapter(List<String> list){
            this.mList = list;

        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new RecyclerViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            holder.mImgView.setImageResource(dias.androidnewsapp.R.drawable.folder);
            holder.mTextView.setText(mList.get(position));
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
    }

}