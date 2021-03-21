(ns app.auth.events
  (:require [re-frame.core :refer [reg-event-fx]]))

(reg-event-fx
 :sign-up
 (fn [{:keys [db]} [_ {:keys [first-name last-name email password]}]]
   {:db (-> db
            (assoc-in [:auth :uid] email)
            (assoc-in [:users email] {:id email
                                      :profile {:first-name first-name
                                                :last-name last-name
                                                :email email
                                                :password password
                                                :img "img/avatar.jpg"}
                                      :saved #{}
                                      :inboxes {}}))
    :dispatch [:set-active-nav :saved]}))

(reg-event-fx
 :log-out
 (fn [{:keys [db]} _]
   {:db (assoc-in db [:auth :uid] nil)
    :dispatch [:set-active-nav :recipes]}))
