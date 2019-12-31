package com.louiewh.keeprunning.model.home;

import com.louiewh.keeprunning.data.DailyStory;
import com.louiewh.keeprunning.data.Lastest;
import com.louiewh.keeprunning.mvp.IBaseView;

public interface IHomeView extends IBaseView {

    void updateLastest(Lastest lastest);

    void updateBefore(DailyStory dailyStory);
}
