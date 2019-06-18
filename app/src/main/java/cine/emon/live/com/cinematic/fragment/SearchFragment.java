package cine.emon.live.com.cinematic.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Objects;

import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.adapter.CategoryAdapter;
import cine.emon.live.com.cinematic.helper.MyDividerItemDecoration;
import cine.emon.live.com.cinematic.model.Category;
import cine.emon.live.com.cinematic.model.Movie;

public class SearchFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private ArrayList<Category> categories = new ArrayList<>();
    private CategoryAdapter mAdapter;


    public SearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_search, container, false);
        initToolbar();
        initView();
        initViewRecyclerView();
        return view;
    }

    private void initToolbar() {
        Toolbar mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mToolbar.setTitle(" ");
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(mToolbar);



        /*Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/28 Days Later.ttf");
        tvToolbarFont.setText(getString(R.string.app_name));
        tvToolbarFont.setTypeface(font);*/
    }

    private void initView() {
        ImageButton imageButtonSearch = (ImageButton) view.findViewById(R.id.img_btn_search);
        final EditText editTextSearch = (EditText) view.findViewById(R.id.edt_search);
      /*  editTextSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                editTextSearch.post(new Runnable() {
                    @Override
                    public void run() {
                        InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
                        assert imm != null;
                        imm.showSoftInput(editTextSearch, InputMethodManager.SHOW_IMPLICIT);
                    }
                });
            }
        });
        editTextSearch.requestFocus();*/

        editTextSearch.requestFocus();
        // Check if no view has focus:
        View view = Objects.requireNonNull(getActivity()).getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);

            //imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }


    private void initViewRecyclerView() {

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_category_list);
        mAdapter = new CategoryAdapter(getActivity(), categories);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        // recyclerView.setItemAnimator(new DefaultItemAnimator());
       /* recyclerView.addItemDecoration(new MyDividerItemDecoration(2,
                Objects.requireNonNull(getActivity()).getResources().getColor(R.color.border_color)));
*/
        recyclerView.setAdapter(mAdapter);
        recyclerView.setFocusable(false);
        prepareCategoryList();
    }

    private void prepareCategoryList() {

        Category category1 = new Category("Action Movie");
        categories.add(category1);

        Category category2 = new Category("Adventure Movies");
        categories.add(category2);

        Category category3 = new Category("Horror Movies");
        categories.add(category3);

        Category category4 = new Category("Romantic Movies");
        categories.add(category4);

        Category category5 = new Category("Fantasy Movies");
        categories.add(category5);

        Category category6 = new Category("Comedy Movies");
        categories.add(category6);

        Category category7 = new Category("Thriller Movies");
        categories.add(category7);

        Category category8 = new Category("Sifi Movies");
        categories.add(category8);

        Category category9 = new Category("Bio Movies");
        categories.add(category9);

        /*Category category10 = new Category("Animation Movies");
        categories.add(category10);*/

        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void onPause() {
        super.onPause();
    }
}
