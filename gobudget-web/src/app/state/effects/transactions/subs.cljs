(ns app.state.effects.transactions.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
 :transaction-history
 (fn [db _]
   (get-in db [:transaction-history])))

(reg-sub
 :modal
 (fn [db _] (:modal db)))