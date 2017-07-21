package training.android.ui.habrhabrfeedreader.mainList.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import training.android.ui.habrhabrfeedreader.R;

/**
 * Created by guedi on 7/21/2017.
 */

public class MainRecyclerViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvCategories;
    private TextView tvDescription;
    private TextView tvCreator;

    public MainRecyclerViewHolder(View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.text_view_holder_title);
        tvDate = itemView.findViewById(R.id.text_view_holder_date);
        tvCategories = itemView.findViewById(R.id.text_view_holder_categories);
        tvDescription = itemView.findViewById(R.id.text_view_holder_description);
        tvCreator =itemView.findViewById(R.id.text_view_holder_creator);

    }

    public void setData(String title, String date, List<String> categories, String description,
                        String creator){
        tvTitle.setText(title);
        tvDate.setText(date);
        tvDescription.setText(description);
        StringBuilder str = new StringBuilder();
        for (String category : categories) str.append(category+ ", ");
        tvCategories.setText(str.toString());
        tvCreator.setText(creator);

    }
}
