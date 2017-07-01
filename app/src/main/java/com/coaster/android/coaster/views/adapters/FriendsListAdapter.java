package com.coaster.android.coaster.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coaster.android.coaster.R;
import com.coaster.android.coaster.models.User;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Albert on 6/12/17.
 */

public class FriendsListAdapter extends RecyclerView.Adapter<FriendsListAdapter.FriendsHolder> {
    public List<User> friendsList;


    public FriendsListAdapter(ArrayList<User> list) {
        this.friendsList = list;
    }

    @Override
    public FriendsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.friends_item, parent, false);


        return new FriendsHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendsHolder holder, int position) {
        holder.friendsTextView.setText(friendsList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }

    public class FriendsHolder extends RecyclerView.ViewHolder {

        TextView friendsTextView;

        public FriendsHolder(View itemView) {
            super(itemView);

            friendsTextView = (TextView) itemView.findViewById(R.id.friends_name_textView);
        }
    }
}
