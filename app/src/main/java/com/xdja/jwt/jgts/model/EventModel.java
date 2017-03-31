package com.xdja.jwt.jgts.model;

import android.os.AsyncTask;

import com.gouhao.frame.model.BaseModel;
import com.xdja.jwt.jgts.bean.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouhao on 3/31/2017.
 */

public class EventModel extends BaseModel {
    public void getMyCreateEvent(BaseModel.Callback callback) {
        new GetMyCreateEventTask(callback).execute();
    }

    private class GetMyCreateEventTask extends AsyncTask<Void, Void, List<Event>> {
            private Callback callback;
        public GetMyCreateEventTask(Callback callback) {
            this.callback = callback;
        }

        @Override
        protected List<Event> doInBackground(Void... params) {
            List<Event> list = new ArrayList<>();
            for(int i = 0; i < 15; i++) {
                Event event = new Event();
                event.setCallTime("2012-12-12 12-12");
                event.setAddress("锦业路" + (i + 1));
                list.add(event);
            }
            return list;
        }

        @Override
        protected void onPostExecute(List<Event> events) {
            if(callback != null) {
                callback.executeFinish(events);
            }
        }
    }
}
