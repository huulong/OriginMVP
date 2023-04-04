package longh.dev.mvppattern.Constract;

import android.widget.Adapter;

public interface ConstractList {
    interface IView{
        void showDeleteSuccess();
        void showDeleteFailed();
    }
    interface IPresenter{
        Adapter list();
        void deleteItem(int id);
    }
}
