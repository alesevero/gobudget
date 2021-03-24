(ns app.state.effects.auth.events
  (:require [re-frame.core :refer [reg-event-fx]]))

(reg-event-fx
 :sign-up
 (fn [{:keys [db]} [_ {:keys [first-name last-name email password]}]]
   {:db (-> db
            (assoc-in [:auth :uid] email)
            (update-in [:errors] dissoc :email)
            (assoc-in [:users email] {:id email
                                      :profile {:first-name first-name
                                                :last-name last-name
                                                :email email
                                                :password password
                                                :img "img/avatar.jpg"}
                                      :saved #{}
                                      :inboxes {}}))
    :dispatch [:set-active-nav :transactions]}))

(reg-event-fx
 :log-in
 (fn [{:keys [db]} [_ {:keys [email password]}]]
   (let [user (get-in db [:users email])
         correct-password? (= (get-in user [:profile :password]) password)]
     (cond
       (not user) {:db (assoc-in db
                                 [:errors :email]
                                 "User or password are incorrect")}
       (not correct-password?) {:db (assoc-in db
                                              [:errors :email]
                                              "User or password are incorrect")}
       correct-password? {:db (-> db
                                  (assoc-in [:auth :uid] email)
                                  (update-in [:errors] dissoc :email))
                          :dispatch [:set-active-nav :transactions]}))))

(reg-event-fx
 :log-out
 (fn [{:keys [db]} _]
   {:db (assoc-in db [:auth :uid] nil)
    :dispatch [:set-active-nav :sign-in]}))
