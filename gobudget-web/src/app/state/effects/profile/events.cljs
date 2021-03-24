(ns app.state.effects.profile.events
  (:require [re-frame.core :refer [reg-event-fx
                                   reg-event-db]]))

(reg-event-db
 :update-profile
 (fn [db [_ profile]]
   (let [uid (get-in db [:auth :uid])]
     (update-in db [:users uid :profile]
                merge (select-keys profile [:first-name :last-name])))))

(reg-event-fx
 :delete-account
 (fn [{:keys [db]} _]
   (let [uid (get-in db [:auth :uid])]
     {:db (-> db
              (assoc-in [:auth :uid] nil)
              (update-in [:users] dissoc uid))
      :dispatch [:set-active-nav :sign-in]})))
