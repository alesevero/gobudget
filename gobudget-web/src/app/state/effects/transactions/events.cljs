(ns app.state.effects.transactions.events
  (:require [re-frame.core :refer [reg-event-fx
                                   reg-event-db]]))

(reg-event-fx
 :create-transaction
 (fn [{:keys [db]} [_ transaction]]
   {:db (-> db
            (assoc-in [:transaction-history] (conj (get-in db [:transaction-history]) transaction)))
    :dispatch [:modal {:show? false :child nil}]}))

(reg-event-db
 :modal
 (fn [db [_ data]]
   (assoc-in db [:modal] data)))
