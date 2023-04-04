package longh.dev.mvppattern.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import longh.dev.mvppattern.Constract.ConstractList;
import longh.dev.mvppattern.R;
import longh.dev.mvppattern.persenter.PresenterList;

public class ListUserActivity extends AppCompatActivity implements ConstractList.IView{
    ConstractList.IPresenter mIPresenter;
    ListView lstUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        init();
    }
    void init(){
        lstUser = findViewById(R.id.listUser);
        mIPresenter = new PresenterList(this);
        lstUser.setAdapter((ListAdapter) mIPresenter.list());
    }
    @Override
    public void showDeleteSuccess() {

    }

    @Override
    public void showDeleteFailed() {

    }
}