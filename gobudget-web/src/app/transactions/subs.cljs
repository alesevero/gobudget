(ns app.transactions.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
 :transaction-history
 (fn [db _]
   (get-in db [:transaction-history])))
