(ns app.transactions.events
  (:require [re-frame.core :refer [reg-event-fx]]))

(reg-event-fx
 :create-transaction
 (fn [{:keys [db]} [_ transaction]]
   {:db (-> db
            (assoc-in [:transaction-history] (conj (get-in db [:transaction-history]) transaction)))
    :dispatch [:set-active-nav :transactions]}))