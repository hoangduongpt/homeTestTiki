package com.kimduong.hometesttiki.ui.main;

import com.kimduong.hometesttiki.network.MyService;
import com.kimduong.hometesttiki.network.RequestInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter  {
    private MainView mainView;
    private RequestInterface requestInterface;
    private CompositeDisposable compositeDisposable ;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        requestInterface = MyService.getINSTANCE().getRequestInterface();
        compositeDisposable = new CompositeDisposable();
    }

    public void fetchKeyword(){
        Disposable disposable = requestInterface.getListKeyword().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mainView::updateKeyWordList, this::handleError);
        compositeDisposable.add(disposable);
    }

    public void destroy(){
        mainView = null;
        compositeDisposable.dispose();
    }

    public void handleError(Throwable throwable){
        throwable.printStackTrace();
        mainView.showMessage(throwable.getMessage());
    }
}
