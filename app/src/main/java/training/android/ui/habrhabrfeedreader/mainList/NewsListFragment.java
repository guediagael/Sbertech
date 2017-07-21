package training.android.ui.habrhabrfeedreader.mainList;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import training.android.ui.habrhabrfeedreader.R;


public class NewsListFragment extends Fragment implements MainListContract.MainListView{

    private static final String ARG_URL = "baseUrl";

    private String mBaseUrl;

    private MainListContract.MainListPresenter mPresenter;

    private List<Map<String,Object>> mArticles;
    private RecyclerView rvNewsList;

    public NewsListFragment() {
        // Required empty public constructor
    }

    public static NewsListFragment newInstance(String baseUrl) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_URL, baseUrl);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mBaseUrl = getArguments().getString(ARG_URL);
        }
        mArticles = new ArrayList<>();
        mPresenter = new MainPresenter(this);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvNewsList = view.findViewById(R.id.recycler_main_list);
        rvNewsList.setLayoutManager( new LinearLayoutManager(getActivity()));
        rvNewsList.setAdapter(new MainListAdapter(mArticles));

        mPresenter.fetchData(mBaseUrl);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void DataLoaded(List<Map<String, Object>> news) {
        mArticles.clear();
        mArticles.addAll(news);
        rvNewsList.getAdapter().notifyDataSetChanged();
    }

}
