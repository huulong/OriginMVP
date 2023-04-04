package longh.dev.mvppattern.persenter;

import android.app.Activity;
import android.widget.Adapter;

import longh.dev.mvppattern.Constract.ConstractList;
import longh.dev.mvppattern.data.Database;
import longh.dev.mvppattern.data.DatabaseDao;
import longh.dev.mvppattern.data.adapter.AdapterUser;
import longh.dev.mvppattern.data.dao.UserDao;

public class PresenterList implements ConstractList.IPresenter {
    ConstractList.IView mIView;

    public PresenterList(ConstractList.IView mIView) {
        this.mIView = mIView;
        DatabaseDao.init(new Database((Activity) mIView));
    }


    @Override
    public Adapter list() {
        UserDao mUserDao = DatabaseDao.getInstance().getUserDao();
        AdapterUser adapterUser = new AdapterUser((Activity) mIView, mUserDao.findAll());
        return adapterUser;
    }

    @Override
    public void deleteItem(int id) {
        UserDao mUserDao = DatabaseDao.getInstance().getUserDao();
        if(mUserDao.delete(id) == true){
            mIView.showDeleteSuccess();
        }else mIView.showDeleteFailed();
    }
}
